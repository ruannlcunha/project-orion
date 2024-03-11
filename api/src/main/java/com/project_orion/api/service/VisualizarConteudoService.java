package com.project_orion.api.service;

import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.ImagemResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.service.core.BuscarConteudoService;
import com.project_orion.api.service.core.BuscarImagemService;
import com.project_orion.api.service.core.ConverterListasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.project_orion.api.mapper.ConteudoMapper.toResponse;


@Service
public class VisualizarConteudoService {

    @Autowired
    private BuscarConteudoService buscarConteudoService;

    @Autowired
    private BuscarImagemService buscarImagemService;

    @Autowired
    private ConverterListasService converterListasService;

    public ConteudoResponse visualizar(Long conteudoId) {
        Conteudo conteudo = buscarConteudoService.porId(conteudoId);

        SecaoResponse[] secoes = converterListasService.converterSecoes(conteudo.getSecoes());

        ImagemResponse[] imagens = converterListasService.converterImagens(conteudo.getImagens());

        return toResponse(conteudo, secoes, imagens);
    }
}
