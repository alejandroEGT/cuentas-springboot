package com.cuentas.cuentas.entidades;

import com.cuentas.cuentas.entidades.enumeracion.TipoCuenta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
@Entity
@Table(name = "cuentas")
public class Cuentas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /*@NotEmpty(message = "Debe ingresar una fecha")*/
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Positive(message = "El valor no puede ser negativo")
    /*@Size(min = 0, max = 100000)*/
    @Column(name = "monto")
    private BigInteger monto;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta")
    private TipoCuenta tipoCuenta;
    @JsonIgnore
    @ManyToOne(optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id", nullable=false)
    private Usuario usuario;

    public Cuentas(){}
    public Cuentas(Integer id, LocalDateTime fecha, BigInteger monto, TipoCuenta tipoCuenta, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.tipoCuenta = tipoCuenta;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigInteger getMonto() {
        return monto;
    }

    public void setMonto(BigInteger monto) {
        this.monto = monto;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
