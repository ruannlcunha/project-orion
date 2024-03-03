package com.project_orion.api.controller;

import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.service.AdicionarConteudoService;
import com.project_orion.api.service.ExcluirConteudoService;
import com.project_orion.api.service.ListarConteudosService;
import com.project_orion.api.service.VisualizarConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/conteudos")
public class ConteudoController {

    @Autowired
    private AdicionarConteudoService adicionarConteudoService;

    @Autowired
    private VisualizarConteudoService visualizarConteudoService;

    @Autowired
    private ExcluirConteudoService excluirConteudoService;

    @Autowired
    private ListarConteudosService listarConteudosService;

    @ResponseStatus(CREATED)
    @PostMapping
    public ConteudoResponse adicionar(@Valid @RequestBody ConteudoRequest request) {
        return adicionarConteudoService.adicionar(request);
    }

    @ResponseStatus(OK)
    @GetMapping("/{conteudoId}")
    public ConteudoResponse visualizar(@PathVariable Long conteudoId) {
        return visualizarConteudoService.visualizar(conteudoId);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{conteudoId}")
    public void excluir(@PathVariable Long conteudoId) {
        excluirConteudoService.excluir(conteudoId);
    }


    @GetMapping("/listar")
    public List<ConteudoResponse> listar(@RequestParam(value = "filtro", required = false) String filtro,
                                         @RequestParam(value = "categoria", required = false) String categoria) {
        return listarConteudosService.listar(filtro, categoria);
    }

}
