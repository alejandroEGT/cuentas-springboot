package com.cuentas.cuentas.servicios;

import com.cuentas.cuentas.entidades.Tarea;
import com.cuentas.cuentas.repositorios.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;


    @Transactional(readOnly = true)
    public Iterable<Tarea> findAll(){
        return tareaRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Optional<Tarea> findByid(Integer id){
        return tareaRepository.findById(id);
    }
    @Transactional
    public Tarea save(Tarea tarea){
        return tareaRepository.save(tarea);
    }
}
