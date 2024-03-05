package com.project_orion.api.service.core;

import com.project_orion.api.security.repository.PermissaoRepository;
import com.project_orion.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.project_orion.api.security.domain.Funcao.ADMIN;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
public class ValidarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService autenticadoService;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void validarDono(Long donoId) {
        if(!donoId.equals(autenticadoService.get().getId())) {
            throw new ResponseStatusException(FORBIDDEN, "Você não é dono deste usuário.");
        }
    }

    public void validarAdmin(Long usuarioId) {
        if(!permissaoRepository.existsByUsuarioIdAndFuncao(usuarioId, ADMIN)) {
            throw new ResponseStatusException(FORBIDDEN, "Você não é um administrador.");
        }
    }
}
