package com.ejemplo.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @GetMapping
    public ResponseEntity<?> getAllAlumnos() {
        return ResponseEntity.ok("Lista de alumnos (requiere token)");
    }

    @PostMapping
    public ResponseEntity<?> createAlumno(@RequestBody Object alumno) {
        return ResponseEntity.ok("Alumno creado: " + alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable int id, @RequestBody Object alumno) {
        return ResponseEntity.ok("Alumno actualizado ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAlumno(@PathVariable int id) {
        return ResponseEntity.ok("Alumno eliminado ID: " + id);
    }
}
