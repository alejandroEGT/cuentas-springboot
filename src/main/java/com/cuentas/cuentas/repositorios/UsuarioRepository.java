package com.cuentas.cuentas.repositorios;

import com.cuentas.cuentas.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u")
    Iterable<Usuario> findAllCustom();

    @Query(value = "select * from usuarios where lower(nombre) LIKE lower('%'||:nombre ||'%')", nativeQuery = true)
    Iterable<Usuario> buscarPorNombre(@Param("nombre")String nombre);

}
