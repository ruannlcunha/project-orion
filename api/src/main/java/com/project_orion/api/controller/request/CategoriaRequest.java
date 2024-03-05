package com.project_orion.api.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter
public class CategoriaRequest {

    @NotBlank
    @Size(max = 128)
    private String nome;


}
