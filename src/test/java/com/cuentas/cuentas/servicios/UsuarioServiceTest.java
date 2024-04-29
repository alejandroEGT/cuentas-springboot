package com.cuentas.cuentas.servicios;

import com.cuentas.cuentas.datos.DatosDummy;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.repositorios.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Array;
import java.util.*;

import static com.cuentas.cuentas.datos.DatosDummy.usuario1;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
class UsuarioServiceTest {

    UsuarioService usuarioDAO;
    UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp(){
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioDAO = new UsuarioService(usuarioRepository);
        System.out.println(usuarioDAO);
    }

    @Test
    void findAllCustom() {

    }

    @Test
    void save() {
        int var = 9;
        int var2 = 10;
        int result = var + var2;

        assertThat(result > 20).isFalse();
    }

    @Test
    void findAll() {
    }

    @Test
    void findByid() {
        Integer id = 1;
        Optional<Usuario> usuario = Optional.of(DatosDummy.usuario1());

        System.out.println("NOMBRE:::::: " + usuario.get().getNombre());
        when(usuarioRepository.findById(id))
                .thenReturn(usuario);

        //when
        Optional<Usuario> expected = usuarioDAO.findByid(id);
        System.out.println("expected NOMBRE:::::: " + expected.get().getNombre());
        //then
        assertThat(expected.get().getNombre()).isEqualTo(DatosDummy.usuario1().getNombre());

        verify(usuarioRepository).findById(id);

    }

    @Test
    @DisplayName("buscar por nombre all")
    void buscarPorNombre() {
        //when
        usuarioDAO.buscarPorNombre("all");
        //then
        verify(usuarioRepository).findAll();
    }

    @Test
    @DisplayName("buscar por nombre")
    void testBuscarPorNombre() {
        //when
        usuarioDAO.buscarPorNombre("damian");
        //then
        verify(usuarioRepository).buscarPorNombre("damian");
    }
}