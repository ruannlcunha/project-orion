package com.project_orion.api.service;

import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.service.core.BuscarConteudoService;
import com.project_orion.api.service.core.BuscarImagemService;
import com.project_orion.api.util.ConverterSecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project_orion.api.mapper.ConteudoMapper.toResponse;


@Service
public class VisualizarConteudoService {

    @Autowired
    private BuscarConteudoService buscarConteudoService;

    @Autowired
    private BuscarImagemService buscarImagemService;

    public ConteudoResponse visualizar(Long conteudoId) {
        Conteudo conteudo = buscarConteudoService.porId(conteudoId);

        String[] imagens = buscarImagemService.emVetorPorConteudoId(conteudo.getId());

        SecaoResponse[] secoes = ConverterSecoes.converterPorList(conteudo.getSecoes());

        return toResponse(conteudo, secoes, imagens);
    }
}
