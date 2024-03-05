package com.project_orion.api.mapper;

import com.project_orion.api.controller.request.UsuarioRequest;
import com.project_orion.api.controller.response.UsuarioResponse;
import com.project_orion.api.domain.Usuario;

public class UsuarioMapper {

    public static Usuario toEntity(UsuarioRequest request) {
        Usuario entity = new Usuario();
        entity.setNome(request.getNome());
        entity.setEmail(request.getEmail());
        return entity;
    }

    public static UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        return response;
    }

}
