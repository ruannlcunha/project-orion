package com.project_orion.api.mapper;


import com.project_orion.api.controller.request.SecaoRequest;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Secao;

public class SecaoMapper {

    public static Secao toEntity(SecaoRequest request) {
        return Secao.builder()
                .titulo(request.getTitulo())
                .descricao(request.getDescricao())
                .build();
    }

    public static SecaoResponse toResponse(Secao secao) {
        return SecaoResponse.builder()
                .id(secao.getId())
                .titulo(secao.getTitulo())
                .descricao(secao.getDescricao())
                .build();
    }
}
