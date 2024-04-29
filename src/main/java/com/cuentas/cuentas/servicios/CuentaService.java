package com.cuentas.cuentas.servicios;

import com.cuentas.cuentas.entidades.Cuentas;
import com.cuentas.cuentas.repositorios.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CuentaService {

    @Autowired
    private CuentaRepository cuentaRepository;

    public Cuentas save(Cuentas cuenta){
        return cuentaRepository.save(cuenta);
    }
    public Iterable<Cuentas> cuentasPorUsuario(Integer id){
        return cuentaRepository.cuentasPorUsuario(id);
    }
    public Iterable<?> findAll(){
        return cuentaRepository.findAll();
    }
}
