package com.project_orion.api.controller;

import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoMinimoResponse;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.service.AdicionarConteudoService;
import com.project_orion.api.service.RemoverConteudoService;
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
    private RemoverConteudoService removerConteudoService;

    @Autowired
    private ListarConteudosService listarConteudosService;

    @ResponseStatus(CREATED)
    @PostMapping
    public void adicionar(@Valid @RequestBody ConteudoRequest request) {
        adicionarConteudoService.adicionar(request);
    }

    @ResponseStatus(OK)
    @GetMapping("/{conteudoId}")
    public ConteudoResponse visualizar(@PathVariable Long conteudoId) {
        return visualizarConteudoService.visualizar(conteudoId);
    }

    @ResponseStatus(OK)
    @DeleteMapping("/{conteudoId}")
    public void remover(@PathVariable Long conteudoId) {
        removerConteudoService.remover(conteudoId);
    }

    @GetMapping
    public List<ConteudoMinimoResponse> listar(@RequestParam(value = "filtro", required = false) String filtro,
                                               @RequestParam(value = "categoria") Long categoria) {
        return listarConteudosService.listar(filtro, categoria);
    }

}
