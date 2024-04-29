package com.cuentas.cuentas.controladores;

import com.cuentas.cuentas.entidades.InformacionUsuario;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.entidades.modelos.ReqInfoUsuario;
import com.cuentas.cuentas.repositorios.UsuarioRepository;
import com.cuentas.cuentas.servicios.InfoUsuarioService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class InfoUsuarioController {

    @Autowired
    private InfoUsuarioService infoUsuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping(value = "/guardar-info-usuario")
    public ResponseEntity<Object> guardar(@RequestBody ReqInfoUsuario infoUsuario){
        Optional<Usuario> usuario = usuarioRepository.findById(infoUsuario.usuario_id);


        System.out.println("id:: " + usuario.get().getId());
        InformacionUsuario iu = new InformacionUsuario(
                null,
                usuario.get(),
                infoUsuario.telefono,
                infoUsuario.correo,
                infoUsuario.direccion
        );
        infoUsuarioService.save(iu);

        return ResponseEntity.ok(infoUsuario);
    }

    @PutMapping("actualizar-info-usuario/{id}")
    public ResponseEntity<Optional<InformacionUsuario>> actualizaDetalle(@PathVariable Integer id, @RequestBody ReqInfoUsuario info) throws BadRequestException {
        Optional<InformacionUsuario> infoExistente = infoUsuarioService.findByid(id);
        Optional<InformacionUsuario> update = infoUsuarioService.update(id, infoExistente, info);
        return ResponseEntity.ok(update);
    }

    @GetMapping(value = "/info-usuario/{id}")
    public ResponseEntity<InformacionUsuario> detallePorusuario(@PathVariable("id") Integer id){
        System.out.println("detalle___ID::::" + id);
        InformacionUsuario detalle = infoUsuarioService.detallePorUsuario(id);
        return ResponseEntity.ok(detalle);
    }
}
