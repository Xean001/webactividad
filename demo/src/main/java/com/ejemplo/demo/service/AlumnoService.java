package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Alumno;
import com.ejemplo.demo.model.Grupo;
import com.ejemplo.demo.repository.AlumnoRepository;
import com.ejemplo.demo.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno getAlumnoById(int id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
    }

    public Alumno createAlumno(Alumno alumno) {
        // Si el alumno tiene un grupo, verificar que exista
        if (alumno.getGrupo() != null && alumno.getGrupo().getId() != 0) {
            Grupo grupo = grupoRepository.findById(alumno.getGrupo().getId())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado con id: " + alumno.getGrupo().getId()));
            alumno.setGrupo(grupo);
        }
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(int id, Alumno alumnoDetails) {
        Alumno alumno = getAlumnoById(id);
        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setApellido(alumnoDetails.getApellido());
        
        // Actualizar grupo si viene en los detalles
        if (alumnoDetails.getGrupo() != null && alumnoDetails.getGrupo().getId() != 0) {
            Grupo grupo = grupoRepository.findById(alumnoDetails.getGrupo().getId())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado con id: " + alumnoDetails.getGrupo().getId()));
            alumno.setGrupo(grupo);
        }
        
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(int id) {
        Alumno alumno = getAlumnoById(id);
        alumnoRepository.delete(alumno);
    }
}
