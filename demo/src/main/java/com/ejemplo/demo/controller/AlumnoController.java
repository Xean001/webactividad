package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Alumno;
import com.ejemplo.demo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping
    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumno actualizar(@PathVariable Integer id, @RequestBody Alumno alumno) {
        alumno.setId(id);
        return alumnoRepository.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        alumnoRepository.deleteById(id);
    }
}
