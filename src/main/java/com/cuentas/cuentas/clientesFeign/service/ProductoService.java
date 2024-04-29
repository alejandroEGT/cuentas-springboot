package com.cuentas.cuentas.clientesFeign.service;

import com.cuentas.cuentas.clientesFeign.models.Producto;

import java.util.List;

public interface ProductoService {
    public List<Producto> findAll();
    public Producto findBy(Long id, Integer cantidad);
}
