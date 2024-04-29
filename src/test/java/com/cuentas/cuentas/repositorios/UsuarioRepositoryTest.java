package com.cuentas.cuentas.repositorios;

import com.cuentas.cuentas.datos.DatosDummy;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.servicios.UsuarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UsuarioRepositoryTest {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Test
    @DisplayName("find all custom users")
    void findAllCustom() {
        //given
        usuarioRepository.save(DatosDummy.usuario1());
        usuarioRepository.save(DatosDummy.usuario2());

        //when
        Iterable<Usuario> list = usuarioRepository.findAll();
        System.out.println("!!!::::::");
        list.forEach(l -> l.getNombre());
        System.out.println("LOREM::> " + ( ((List<Usuario>)list).size()) );
        //then
        assertThat(((List<Usuario>)list).size() == 1).isFalse();
    }
}