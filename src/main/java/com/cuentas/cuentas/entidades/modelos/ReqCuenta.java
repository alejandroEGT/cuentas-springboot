package com.cuentas.cuentas.entidades.modelos;

import com.cuentas.cuentas.entidades.enumeracion.TipoCuenta;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class ReqCuenta {
    @NotEmpty(message = "PONE LA FECHA")
    public String fecha;
    @Positive(message = "PONE MONTO POSITIVO")
    public BigInteger monto;
    public String tipo_cuenta;
    public Integer usuario_id;

    public ReqCuenta(String fecha, BigInteger monto, String tipo_cuenta, Integer usuarioId) {
        this.fecha = fecha;
        this.monto = monto;
        this.tipo_cuenta = tipo_cuenta;
        this.usuario_id = usuarioId;
    }
}
