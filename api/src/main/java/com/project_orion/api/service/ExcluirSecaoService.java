package com.project_orion.api.service;

import com.project_orion.api.domain.Secao;
import com.project_orion.api.repository.SecaoRepository;
import com.project_orion.api.service.core.BuscarSecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExcluirSecaoService {

    @Autowired
    private BuscarSecaoService buscarSecaoService;

    @Autowired
    private SecaoRepository secaoRepository;


    @Transactional
    public void excluir(Long secaoId) {
        Secao secao = buscarSecaoService.porId(secaoId);

        secao.setAtivo(false);

        secaoRepository.save(secao);
    }

}
