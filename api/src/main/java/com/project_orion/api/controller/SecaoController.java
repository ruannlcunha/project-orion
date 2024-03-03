package com.project_orion.api.controller;

import com.project_orion.api.controller.request.SecaoRequest;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.service.AdicionarSecaoService;
import com.project_orion.api.service.ExcluirSecaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/secoes")
public class SecaoController {

    @Autowired
    private AdicionarSecaoService adicionarSecaoService;

    @Autowired
    private ExcluirSecaoService excluirSecaoService;

    @ResponseStatus(CREATED)
    @PostMapping("/{conteudoId}")
    public SecaoResponse adicionar(@Valid @RequestBody SecaoRequest request, @PathVariable Long conteudoId) {
        return adicionarSecaoService.adicionar(request, conteudoId);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{secaoId}")
    public void excluir(@PathVariable Long secaoId) {
        excluirSecaoService.excluir(secaoId);
    }


}
