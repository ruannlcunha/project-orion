package com.project_orion.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ImagemResponse {

    private Long id;

    private String nome;

    private String dataUri;

}
