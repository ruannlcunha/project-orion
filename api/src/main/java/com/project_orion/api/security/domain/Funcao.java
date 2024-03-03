package com.project_orion.api.security.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Funcao {

    USUARIO(Nomes.USUARIO),
    ADMIN(Nomes.ADMIN);

    public static class Nomes {
        public static final String USUARIO = "ROLE_USUARIO";
        public static final String ADMIN = "ROLE_ADMIN";
    }

    private final String role;
}
