package com.cuentas.cuentas.repositorios;

import com.cuentas.cuentas.entidades.Cuentas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends CrudRepository<Cuentas, Integer> {
    @Query(value = "select * from cuentas where usuario_id = :id", nativeQuery = true)
    Iterable<Cuentas> cuentasPorUsuario(@Param("id") Integer id);
}
