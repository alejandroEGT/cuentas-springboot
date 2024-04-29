package com.cuentas.cuentas.controladores;

import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.servicios.UsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/obtener-usuario")
    public ResponseEntity<Iterable<Usuario>> inicial(){
        Iterable<Usuario> list = usuarioService.findAllCustom();
        System.out.println(list);
        return ResponseEntity.ok(list);
    }
    @GetMapping(value = "/obtener-usuario/{nombre}")
    public ResponseEntity<?> buscar(@PathVariable("nombre") String name){
        if(name.equals("conCuentas")){
            Optional<?> list = usuarioService.buscarPorCuentas();
            return ResponseEntity.ok(list);
        }
        Iterable<Usuario> list = usuarioService.buscarPorNombre(name);
        System.out.println("NAME::: " + name);
        return ResponseEntity.ok(list);
    }
    @PostMapping(value = "/guardar-usuario")
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario usuario){
        usuarioService.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping(value = "/actualizar-usuario/{id}")
    public ResponseEntity<Optional<Usuario>> actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) throws BadRequestException {

        Optional<Usuario> usuarioExiste = usuarioService.findByid(id);
        Optional<Usuario> update = usuarioService.update(id, usuarioExiste, usuario);
        return ResponseEntity.ok(update);

    }

    @DeleteMapping(value = "/eliminar-usuario/{id}")
    public String eliminar(@PathVariable Integer id){
        usuarioService.eliminar(id);
        return "OK";
    }
}
