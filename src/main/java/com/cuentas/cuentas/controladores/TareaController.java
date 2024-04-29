package com.cuentas.cuentas.controladores;

import com.cuentas.cuentas.entidades.Tarea;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.entidades.modelos.ReqtareaUsuario;
import com.cuentas.cuentas.servicios.TareaService;
import com.cuentas.cuentas.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@RestController
public class TareaController {
    @Autowired
    private TareaService tareaService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/guardar-tarea")
    public ResponseEntity<Tarea> guardar(@RequestBody Tarea tarea){
        tareaService.save(tarea);
        return ResponseEntity.ok(tarea);
    }

    @GetMapping(value = "/obtener-tareas")
    public ResponseEntity<Iterable<Tarea>> list(){
        return ResponseEntity.ok(tareaService.findAll());
    }

    @PostMapping(value = "/asignar-tarea-usuario")
    public ResponseEntity<Object> asignar(@RequestBody ReqtareaUsuario datos){
        System.out.println("PRINT:::" + datos.tarea_id);

        Optional<Tarea> tarea = tareaService.findByid(datos.tarea_id);
        Optional<Usuario> usuario = usuarioService.findByid(datos.usuario_id);


        tarea.get().getUsuario().add(usuario.get());

        usuarioService.save(usuario.get());

        System.out.println("tarea:: " + tarea.get().getId());
        System.out.println("usuario:: "+usuario.get().getId());

        //tareaService.save(tarea);
        return ResponseEntity.ok(datos);
    }

}
