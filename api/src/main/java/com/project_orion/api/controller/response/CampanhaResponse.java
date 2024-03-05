package com.project_orion.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CampanhaResponse {

    private Long id;

    private String titulo;

    private String imagemFundo;

    private String imagemIcone;

}
