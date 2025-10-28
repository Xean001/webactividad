package com.ejemplo.demo.controller;

import com.ejemplo.demo.model.Grupo;
import com.ejemplo.demo.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public ResponseEntity<List<Grupo>> getAllGrupos() {
        List<Grupo> grupos = grupoService.getAllGrupos();
        return ResponseEntity.ok(grupos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> getGrupoById(@PathVariable int id) {
        Grupo grupo = grupoService.getGrupoById(id);
        return ResponseEntity.ok(grupo);
    }

    @PostMapping
    public ResponseEntity<Grupo> createGrupo(@RequestBody Grupo grupo) {
        Grupo nuevoGrupo = grupoService.createGrupo(grupo);
        return ResponseEntity.ok(nuevoGrupo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> updateGrupo(@PathVariable int id, @RequestBody Grupo grupo) {
        Grupo grupoActualizado = grupoService.updateGrupo(id, grupo);
        return ResponseEntity.ok(grupoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGrupo(@PathVariable int id) {
        grupoService.deleteGrupo(id);
        return ResponseEntity.ok("Grupo eliminado exitosamente con ID: " + id);
    }
}
