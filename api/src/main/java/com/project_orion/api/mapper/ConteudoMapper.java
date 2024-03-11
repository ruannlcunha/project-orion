package com.project_orion.api.mapper;


import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoMinimoResponse;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.ImagemResponse;
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
                                              ImagemResponse[] imagens) {
        return ConteudoResponse.builder()
                .id(conteudo.getId())
                .titulo(conteudo.getTitulo())
                .secoes(secoes)
                .imagens(imagens)
                .build();
    }

    public static ConteudoMinimoResponse toResponseMinimo(Conteudo conteudo, String imagem) {
        return ConteudoMinimoResponse.builder()
                .id(conteudo.getId())
                .titulo(conteudo.getTitulo())
                .imagem(imagem)
                .build();
    }
}
