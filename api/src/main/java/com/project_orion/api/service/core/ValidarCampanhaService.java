package com.project_orion.api.service.core;

import com.project_orion.api.repository.UsuarioCampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarCampanhaService {

    @Autowired
    private UsuarioCampanhaRepository usuarioCampanhaRepository;

    public void validarInscricao(Long usuarioId, Long campanhaId) {
        if(usuarioCampanhaRepository.existsByUsuarioIdAndCampanhaIdAndAtivo(usuarioId, campanhaId, true)){
            throw new ResponseStatusException(BAD_REQUEST, "Você já está inscrito nessa campanha.");
        }
    }
}
