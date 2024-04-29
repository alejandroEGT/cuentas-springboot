package com.cuentas.cuentas.controladores;

import com.cuentas.cuentas.entidades.Cuentas;
import com.cuentas.cuentas.entidades.InformacionUsuario;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.entidades.enumeracion.TipoCuenta;
import com.cuentas.cuentas.entidades.modelos.ReqCuenta;
import com.cuentas.cuentas.entidades.modelos.ReqInfoUsuario;
import com.cuentas.cuentas.repositorios.CuentaRepository;
import com.cuentas.cuentas.repositorios.UsuarioRepository;
import com.cuentas.cuentas.servicios.CuentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class CuentasController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CuentaService cuentaService;

    @PostMapping(value = "/guardar-cuenta-usuario")
    public ResponseEntity<?> guardar(@Valid @RequestBody ReqCuenta reqCuenta, BindingResult result){
        Map<String, Object> validaciones = new HashMap<>();

        if(result.hasErrors()){
            result.getFieldErrors().forEach(e -> validaciones.put(e.getField(), e.getDefaultMessage()));
            System.out.println("HASERROR:::::" +validaciones.toString());
            return ResponseEntity.badRequest().body(validaciones);
        }else{
            System.out.println("OOOOKKKKK:::::::");
            Optional<Usuario> usuario = usuarioRepository.findById(reqCuenta.usuario_id);

            System.out.println("id:: " + usuario.get().getId());
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
            LocalDateTime resultt = LocalDateTime.parse(reqCuenta.fecha.toString(), format);
            Cuentas cuenta = new Cuentas(null, resultt, reqCuenta.monto, reqCuenta.tipo_cuenta.equals("ingreso") ? TipoCuenta.INGRESO:TipoCuenta.EGRESO, usuario.get());
            return ResponseEntity.ok(cuentaService.save(cuenta));
        }
    }

    @GetMapping("obtener-cuentas-por-usuario/{usuario}")
    public Iterable<?> cuentasPorUsuario(@PathVariable Integer usuario){
        System.out.println("USUARIO::" + usuario);
        //return cuentaService.findAll();
        return cuentaService.cuentasPorUsuario(usuario);
    }
}
