package com.cuentas.cuentas.servicios;

import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.repositorios.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Qualifier("usuarioService")
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        super();
        this.repository = repository;
    }

    public Iterable<Usuario> findAllCustom(){
        return repository.findAllCustom();
    }

    public Usuario save(Usuario usuario){
        return repository.save(usuario);
    }

    public Iterable<Usuario> findAll(){
        return repository.findAll();
    }
    public  Optional<Usuario> findByid(Integer id){
        return repository.findById(id);
    }

    public Iterable<Usuario> buscarPorNombre(String nombre){
        if(nombre.equals("all")){
            return repository.findAll();
        }
        return repository.buscarPorNombre(nombre);
    }
    public Optional<?> buscarPorCuentas(){
        Iterable<Usuario> usuarios = (Iterable<Usuario>) repository.findAllCustom();
        List<Usuario> usuariosConCuenta = new ArrayList<>();
        AtomicInteger nume = new AtomicInteger();
         usuarios.forEach((usuario) -> {
             if(!usuario.getCuentas().isEmpty()){
                 System.out.println("ITERABLE::"+(nume.getAndIncrement()) + "USER:: "+usuario.getNombre() );
                    usuariosConCuenta.add(usuario);
             }
         });
         return Optional.of((usuariosConCuenta));
    }

    public Optional<Usuario> update(Integer id, Optional<Usuario> usuarioExiste, Usuario usuario) throws BadRequestException {
        if (usuarioExiste.isPresent()) {
            usuarioExiste.get().setNombre(usuario.getNombre());
            usuarioExiste.get().setApellido(usuario.getApellido());
            usuarioExiste.get().setEdad(usuario.getEdad());
            repository.save(usuarioExiste.get());

            return usuarioExiste;
        }else {
            throw new BadRequestException(String.format("asd", id));
        }
    }

    public void eliminar(Integer id){
        repository.deleteById(id);
    }
}
