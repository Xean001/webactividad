package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Grupo;
import com.ejemplo.demo.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Grupo> getAllGrupos() {
        return grupoRepository.findAll();
    }

    public Grupo getGrupoById(int id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con id: " + id));
    }

    public Grupo createGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }

    public Grupo updateGrupo(int id, Grupo grupoDetails) {
        Grupo grupo = getGrupoById(id);
        grupo.setNombre(grupoDetails.getNombre());
        grupo.setDescripcion(grupoDetails.getDescripcion());
        return grupoRepository.save(grupo);
    }

    public void deleteGrupo(int id) {
        Grupo grupo = getGrupoById(id);
        grupoRepository.delete(grupo);
    }
}
