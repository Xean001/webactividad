package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.User;
import com.ejemplo.demo.repository.UserRepository;
import com.ejemplo.demo.security.ServiceJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceJWT jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");

    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

    String token = jwtService.generarToken(user.getUsername());
        return Map.of("token", token);
    }
}
