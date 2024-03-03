package com.project_orion.api.util;

import com.project_orion.api.controller.request.SecaoRequest;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Secao;

import java.util.List;

import static com.project_orion.api.mapper.SecaoMapper.toResponse;

public abstract class ConverterSecoes {

    public static SecaoResponse[] converterPorRequest(SecaoRequest[] requests) {
        SecaoResponse[] secoes = new SecaoResponse[requests.length];

        for(int i=0;i<secoes.length;i++) {
            Secao secao = new Secao();
            secao.setTitulo(requests[i].getTitulo());
            secao.setDescricao(requests[i].getDescricao());

            secoes[i] = toResponse(secao);
        }

        return secoes;
    }

    public static SecaoResponse[] converterPorList(List<Secao> secaoList) {
        SecaoResponse[] secoes = new SecaoResponse[secaoList.size()];

        for(int i=0;i<secoes.length;i++) {
            Secao secao = new Secao();
            secao.setId(secaoList.get(i).getId());
            secao.setTitulo(secaoList.get(i).getTitulo());
            secao.setDescricao(secaoList.get(i).getDescricao());

            secoes[i] = toResponse(secao);
        }

        return secoes;
    }

}
