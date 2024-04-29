package com.cuentas.cuentas.servicios;

import com.cuentas.cuentas.entidades.InformacionUsuario;
import com.cuentas.cuentas.entidades.Usuario;
import com.cuentas.cuentas.entidades.modelos.ReqInfoUsuario;
import com.cuentas.cuentas.repositorios.InfoUsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoUsuarioService {

    @Autowired
    private InfoUsuarioRepository infoUsuarioRepository;

    public InformacionUsuario save(InformacionUsuario iu){
        return infoUsuarioRepository.save(iu);
    }

    public InformacionUsuario detallePorUsuario(Integer id){
        return infoUsuarioRepository.detallePorUsuario(id);
    }

    public Optional<InformacionUsuario> findByid(Integer id){
        return infoUsuarioRepository.findById(id);
    }

    public Optional<InformacionUsuario> update(Integer id, Optional<InformacionUsuario> infoExistente, ReqInfoUsuario info) throws BadRequestException {
        if (infoExistente.isPresent()) {
            infoExistente.get().setCorreo(info.getCorreo());
            infoExistente.get().setTelefono(info.getTelefono());
            infoExistente.get().setDireccion(info.getDireccion());
            infoUsuarioRepository.save(infoExistente.get());

            return infoExistente;
        }else {
            throw new BadRequestException(String.format("asd", id));
        }
    }
}
