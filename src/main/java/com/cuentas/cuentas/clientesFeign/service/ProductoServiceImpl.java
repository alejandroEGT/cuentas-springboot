package com.cuentas.cuentas.clientesFeign.service;

import com.cuentas.cuentas.clientesFeign.ProductoClientrest;
import com.cuentas.cuentas.clientesFeign.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeing")
@Primary
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoClientrest productoClientrest;
    @Override
    public List<Producto> findAll() {
        return productoClientrest.listar().stream().map(p->
                new Producto
                        (p.getId(),
                          p.getNombre(),
                          p.getPrecio(),
                          p.getCreateAt(),
                                ""
                        )
        ).collect(Collectors.toList());
    }

    @Override
    public Producto findBy(Long id, Integer cantidad) {
        return null;
    }
}
