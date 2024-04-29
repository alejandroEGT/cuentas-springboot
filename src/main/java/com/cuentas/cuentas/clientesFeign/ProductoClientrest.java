package com.cuentas.cuentas.clientesFeign;

import com.cuentas.cuentas.clientesFeign.models.Producto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RibbonClient(name="servicio-producto")
@FeignClient(name = "servicio-producto")
public interface ProductoClientrest {
    @GetMapping("/listar")
    public List<Producto> listar();
}
