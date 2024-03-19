package com.project_orion.api.controller;

import com.project_orion.api.controller.response.CampanhaResponse;
import com.project_orion.api.service.InscreverCampanhaService;
import com.project_orion.api.service.ListarCampanhasInscritasService;
import com.project_orion.api.service.ListarCampanhasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {

    @Autowired
    private ListarCampanhasService listarCampanhasService;

    @Autowired
    private ListarCampanhasInscritasService listarCampanhasInscritasService;

    @Autowired
    private InscreverCampanhaService inscreverCampanhaService;

    @GetMapping
    public Page<CampanhaResponse> listarCampanhas(Pageable pageable) {
        return listarCampanhasService.listar(pageable);
    }

    @GetMapping("/inscritas")
    public Page<CampanhaResponse> listarCampanhasInscritas(Pageable pageable) {
        return listarCampanhasInscritasService.listar(pageable);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/inscrever/{campanhaId}")
    public void inscreverCampanha(@PathVariable Long campanhaId) {
        inscreverCampanhaService.inscrever(campanhaId);
    }


}
