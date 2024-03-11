package com.project_orion.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConteudoMinimoResponse {

    private Long id;

    private String titulo;

    private String imagem;

}
