package com.project_orion.api.mapper;


import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;

public class ConteudoMapper {

    public static Conteudo toEntity(ConteudoRequest request) {
        Conteudo conteudo = new Conteudo();
        conteudo.setTitulo(request.getTitulo());
        return conteudo;
    }

    public static ConteudoResponse toResponse(Conteudo conteudo,
                                              SecaoResponse[] secoes,
                                              String[] imagens) {
        return ConteudoResponse.builder()
                .id(conteudo.getId())
                .titulo(conteudo.getTitulo())
                .secoes(secoes)
                .imagens(imagens)
                .build();
    }
}
