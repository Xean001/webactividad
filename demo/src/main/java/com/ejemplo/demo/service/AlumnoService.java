package com.ejemplo.demo.service;

import com.ejemplo.demo.model.Alumno;
import com.ejemplo.demo.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Alumno getAlumnoById(int id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado con id: " + id));
    }

    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public Alumno updateAlumno(int id, Alumno alumnoDetails) {
        Alumno alumno = getAlumnoById(id);
        alumno.setNombre(alumnoDetails.getNombre());
        alumno.setApellido(alumnoDetails.getApellido());
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(int id) {
        Alumno alumno = getAlumnoById(id);
        alumnoRepository.delete(alumno);
    }
}
