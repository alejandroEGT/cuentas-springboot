package com.cuentas.cuentas.entidades.modelos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqInfoUsuario {
    public Integer usuario_id;
    public String telefono;
    public String correo;
    public String direccion;

    public ReqInfoUsuario(Integer usuario_id, String telefono, String correo, String direccion) {
        this.usuario_id = usuario_id;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }
}
