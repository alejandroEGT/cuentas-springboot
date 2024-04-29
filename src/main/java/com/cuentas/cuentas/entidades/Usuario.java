package com.cuentas.cuentas.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Column(name = "edad")
    private Integer edad;
    @OneToMany(mappedBy="usuario")
    private Set<Cuentas> cuentas;
    @OneToOne(mappedBy = "usuario")
    private InformacionUsuario informacionUsuarios;

    @ManyToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Tarea> tareas;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", cuentas=" + cuentas +
                ", informacionUsuarios=" + informacionUsuarios +
                ", tareas=" + tareas +
                '}';
    }

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, Integer edad, Set<Cuentas> cuentas, InformacionUsuario informacionUsuarios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cuentas = cuentas;
        this.informacionUsuarios = informacionUsuarios;
    }

    public Set<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Set<Tarea> tareas) {
        this.tareas = tareas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Set<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Set<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }

    public InformacionUsuario getInformacionUsuarios() {
        return informacionUsuarios;
    }

    public void setInformacionUsuarios(InformacionUsuario informacionUsuarios) {
        this.informacionUsuarios = informacionUsuarios;
    }
}
