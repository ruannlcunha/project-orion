package com.project_orion.api.domain.enums;

import lombok.Getter;

@Getter
public enum CategoriaEnum {
    PROTAGONISTA("Protagonista"), NPC("Npc"), Item("Item"),
    HISTORIA("História"), MONSTRO("Monstro"), OUTRO("Outro");

    private String nome;

    private CategoriaEnum(String nome) {
        this.nome = nome;
    }
}
