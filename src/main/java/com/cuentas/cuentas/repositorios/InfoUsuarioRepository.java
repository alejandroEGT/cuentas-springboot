package com.cuentas.cuentas.repositorios;

import com.cuentas.cuentas.entidades.InformacionUsuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface InfoUsuarioRepository extends CrudRepository<InformacionUsuario, Integer> {

    @Query(value = "select * from informacion_usuarios where usuario_id = :id", nativeQuery = true)
    public InformacionUsuario detallePorUsuario(@Param("id") Integer id);
}
