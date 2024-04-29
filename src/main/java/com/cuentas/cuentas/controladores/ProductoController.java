package com.cuentas.cuentas.controladores;

import com.cuentas.cuentas.clientesFeign.models.Producto;
import com.cuentas.cuentas.clientesFeign.service.ProductoService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    @Qualifier("serviceFeing")
    private ProductoService productoService;

    @GetMapping("/productos/listar")
    public ResponseEntity<List<Producto>> listar(){

        List<Producto> productos = productoService.findAll();
        productos.add(new Producto(9L,"MACBOOK",200.00,new Date(), "Nuevo producto desde proyecto cuentas"));
        return ResponseEntity.ok(productos);
    }
}
