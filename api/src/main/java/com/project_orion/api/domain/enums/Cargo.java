package com.project_orion.api.domain.enums;

import lombok.Getter;

@Getter
public enum Cargo {
    MESTRE("Mestre"), JOGADOR("Jogador"), ESPECTADOR("Espectador");

    private String nome;

    private Cargo(String nome) {
        this.nome = nome;
    }
}
