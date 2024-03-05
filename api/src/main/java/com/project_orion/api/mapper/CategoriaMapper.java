package com.project_orion.api.mapper;


import com.project_orion.api.controller.request.CategoriaRequest;
import com.project_orion.api.controller.response.CategoriaResponse;
import com.project_orion.api.domain.Categoria;

public class CategoriaMapper {

    public static Categoria toEntity(CategoriaRequest request) {
        Categoria categoria = new Categoria();
        categoria.setNome(request.getNome());
        return categoria;
    }

    public static CategoriaResponse toResponse(Categoria entity) {
        return CategoriaResponse.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .build();
    }
}
