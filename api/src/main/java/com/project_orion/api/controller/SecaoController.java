package com.project_orion.api.controller;

import com.project_orion.api.controller.request.SecaoRequest;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.service.AdicionarSecaoService;
import com.project_orion.api.service.RemoverSecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/secoes")
public class SecaoController {

    @Autowired
    private AdicionarSecaoService adicionarSecaoService;

    @Autowired
    private RemoverSecaoService removerSecaoService;

    @ResponseStatus(CREATED)
    @PostMapping("/{conteudoId}")
    public SecaoResponse adicionar(@Valid @RequestBody SecaoRequest request, @PathVariable Long conteudoId) {
        return adicionarSecaoService.adicionar(request, conteudoId);
    }

    @DeleteMapping("/{secaoId}")
    public void remover(@PathVariable Long secaoId) {
        removerSecaoService.remover(secaoId);
    }


}
