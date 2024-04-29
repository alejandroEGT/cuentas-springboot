package com.cuentas.cuentas.datos;

import com.cuentas.cuentas.entidades.Usuario;

public class DatosDummy {
    public static Usuario usuario1(){
        return new Usuario(1, "Damian", "Pizarro", 28, null, null);
    }

    public static Usuario usuario2(){
        return new Usuario(2, "Gustavo", "Parra", 30, null, null);
    }
}
