package com.cuentas.cuentas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String descripcion;
    @Column(nullable = true)
    private String observacion;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tarea_usuario",
            joinColumns = @JoinColumn(name="tarea_id"),
            inverseJoinColumns = @JoinColumn(name="usuario_id")
    )
    private Set<Usuario> usuario;

    public Tarea() {
    }

    public Integer getId() {
        return id;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Set<Usuario> getUsuario() {
        return usuario;
    }

    public void setUsuario(Set<Usuario> usuario) {
        this.usuario = usuario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
