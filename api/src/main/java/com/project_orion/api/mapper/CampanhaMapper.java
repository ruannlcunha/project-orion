package com.project_orion.api.mapper;


import com.project_orion.api.controller.response.CampanhaResponse;
import com.project_orion.api.domain.Campanha;

public class CampanhaMapper {

    public static CampanhaResponse toResponse(Campanha entity,
                                              String imagemFundoUri,
                                              String imagemIconeUri) {
        return CampanhaResponse.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .imagemFundo(imagemFundoUri)
                .imagemIcone(imagemIconeUri)
                .build();
    }
}
