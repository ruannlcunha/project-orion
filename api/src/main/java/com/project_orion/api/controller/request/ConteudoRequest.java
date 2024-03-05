package com.project_orion.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
public class ConteudoRequest {

    @NotBlank
    @Size(max = 128)
    private String titulo;

    @NotNull
    private Long campanhaId;

    @NotNull
    private Long categoriaId;

    private String[] imagens;

    private SecaoRequest[] secoes;


}
