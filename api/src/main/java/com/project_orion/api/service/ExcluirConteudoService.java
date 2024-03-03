package com.project_orion.api.service;

import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.service.core.BuscarConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExcluirConteudoService {

    @Autowired
    private BuscarConteudoService buscarConteudoService;

    @Autowired
    private ConteudoRepository conteudoRepository;


    @Transactional
    public void excluir(Long conteudoId) {
        Conteudo conteudo = buscarConteudoService.porId(conteudoId);

        conteudo.setAtivo(false);

        conteudoRepository.save(conteudo);
    }

}
