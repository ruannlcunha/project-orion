package com.project_orion.api.mapper;


import com.project_orion.api.controller.response.ImagemResponse;
import com.project_orion.api.domain.Imagem;

public class ImagemMapper {

    public static ImagemResponse toResponse(Imagem imagem, String dataUri) {
        return ImagemResponse.builder()
                .id(imagem.getId())
                .nome(imagem.getNome())
                .dataUri(dataUri)
                .build();
    }
}
