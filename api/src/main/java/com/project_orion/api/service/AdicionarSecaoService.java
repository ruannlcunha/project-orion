package com.project_orion.api.service;

import com.project_orion.api.controller.request.SecaoRequest;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.domain.Secao;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.repository.SecaoRepository;
import com.project_orion.api.service.core.BuscarConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project_orion.api.mapper.SecaoMapper.toEntity;
import static com.project_orion.api.mapper.SecaoMapper.toResponse;

@Service
public class AdicionarSecaoService {

    @Autowired
    ConteudoRepository conteudoRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private BuscarConteudoService buscarConteudoService;

    @Transactional
    public SecaoResponse adicionar(SecaoRequest request, Long conteudoId) {
        Secao secao = toEntity(request);
        Conteudo conteudo = buscarConteudoService.porId(conteudoId);
        conteudo.adicionarSecao(secao);

        secaoRepository.save(secao);
        return toResponse(secao);
    }


}
