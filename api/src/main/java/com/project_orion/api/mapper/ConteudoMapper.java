package com.project_orion.api.mapper;


import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.domain.enums.CategoriaEnum;

public class ConteudoMapper {

    public static Conteudo toEntity(ConteudoRequest request) {
        return Conteudo.builder()
                .titulo(request.getTitulo())
                .categoria(CategoriaEnum.valueOf(request.getCategoria()))
                .build();
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
