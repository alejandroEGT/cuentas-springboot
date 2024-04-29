package com.cuentas.cuentas.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "informacion_usuarios")
public class InformacionUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String telefono;
    private String correo;
    private String direccion;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="usuario_id", nullable=false, unique = true)
    private Usuario usuario;

    public InformacionUsuario() {
    }

    public InformacionUsuario(Integer id, Usuario usuario, String telefono, String correo, String direccion) {
        this.id = id;
        this.usuario = usuario;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
