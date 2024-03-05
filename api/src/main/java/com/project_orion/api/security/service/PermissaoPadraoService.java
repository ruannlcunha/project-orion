package com.project_orion.api.security.service;

import com.project_orion.api.security.domain.Permissao;
import org.springframework.stereotype.Service;

import static com.project_orion.api.security.domain.Funcao.USUARIO;

@Service
public class PermissaoPadraoService {

    public Permissao get() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }

}
