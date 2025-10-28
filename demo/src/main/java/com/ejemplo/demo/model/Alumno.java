package com.ejemplo.demo.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    private String apellido;
    
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Grupo grupo;

    public Alumno() {
    }

    public Alumno(int id, String nombre, String apellido, Grupo grupo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupo = grupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
