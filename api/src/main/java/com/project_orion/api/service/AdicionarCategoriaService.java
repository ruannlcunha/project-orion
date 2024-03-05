package com.project_orion.api.service;

import com.project_orion.api.controller.request.CategoriaRequest;
import com.project_orion.api.controller.response.CategoriaResponse;
import com.project_orion.api.domain.Campanha;
import com.project_orion.api.domain.Categoria;
import com.project_orion.api.repository.CategoriaRepository;
import com.project_orion.api.service.core.BuscarCampanhaService;
import com.project_orion.api.service.core.ValidarCategoriaService;
import com.project_orion.api.service.core.ValidarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project_orion.api.mapper.CategoriaMapper.toEntity;
import static com.project_orion.api.mapper.CategoriaMapper.toResponse;

@Service
public class AdicionarCategoriaService {

    @Autowired
    private BuscarCampanhaService buscarCampanhaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidarUsuarioService validarUsuarioService;

    @Autowired
    private ValidarCategoriaService validarCategoriaService;

    @Transactional
    public CategoriaResponse adicionar(Long campanhaId, CategoriaRequest request) {
        Campanha campanha = buscarCampanhaService.porId(campanhaId);

        validarUsuarioService.validarDono(campanha.getDono().getId());
        validarCategoriaService.validarNome(request.getNome());
        validarCategoriaService.validarQuantidade(campanha.getId());

        Categoria categoria = toEntity(request);
        categoria.setAtivo(true);
        campanha.adicionarCategoria(categoria);

        categoriaRepository.save(categoria);
        return toResponse(categoria);
    }
}
