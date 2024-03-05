package com.project_orion.api.controller;

import com.project_orion.api.controller.request.CategoriaRequest;
import com.project_orion.api.controller.response.CategoriaResponse;
import com.project_orion.api.service.AdicionarCategoriaService;
import com.project_orion.api.service.ListarCategoriasService;
import com.project_orion.api.service.RemoverCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private ListarCategoriasService listarCategoriasService;

    @Autowired
    private AdicionarCategoriaService adicionarCategoriaService;

    @Autowired
    private RemoverCategoriaService removerCategoriaService;

    @GetMapping("/{campanhaId}")
    public List<CategoriaResponse> listar(@PathVariable Long campanhaId) {
        return listarCategoriasService.listar(campanhaId);
    }

    @ResponseStatus(CREATED)
    @PostMapping("/{campanhaId}")
    public CategoriaResponse adicionar(@PathVariable Long campanhaId, @RequestBody CategoriaRequest request) {
        return adicionarCategoriaService.adicionar(campanhaId, request);
    }

    @DeleteMapping("/{categoriaId}")
    public void remover(@PathVariable Long categoriaId) {
        removerCategoriaService.remover(categoriaId);
    }

}
