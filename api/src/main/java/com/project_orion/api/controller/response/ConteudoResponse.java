package com.project_orion.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConteudoResponse {

    private Long id;

    private String titulo;

    private SecaoResponse[] secoes;

    private String[] imagens;

}
