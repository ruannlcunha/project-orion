package com.project_orion.api.service;

import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.service.core.BuscarConteudoService;
import com.project_orion.api.service.core.ValidarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RemoverConteudoService {

    @Autowired
    private BuscarConteudoService buscarConteudoService;

    @Autowired
    private ConteudoRepository conteudoRepository;

    @Autowired
    private ValidarUsuarioService validarUsuarioService;


    @Transactional
    public void remover(Long conteudoId) {
        Conteudo conteudo = buscarConteudoService.porId(conteudoId);
        validarUsuarioService.validarDono(conteudo.getCampanha().getDono().getId());

        conteudo.setAtivo(false);

        conteudoRepository.save(conteudo);
    }

}
