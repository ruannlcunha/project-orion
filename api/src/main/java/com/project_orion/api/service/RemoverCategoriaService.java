package com.project_orion.api.service;

import com.project_orion.api.domain.Categoria;
import com.project_orion.api.repository.CategoriaRepository;
import com.project_orion.api.service.core.BuscarCategoriaService;
import com.project_orion.api.service.core.ValidarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RemoverCategoriaService {

    @Autowired
    private BuscarCategoriaService buscarCategoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidarUsuarioService validarUsuarioService;

    @Transactional
    public void remover(Long categoriaId) {
        Categoria categoria = buscarCategoriaService.porId(categoriaId);
        validarUsuarioService.validarDono(categoria.getCampanha().getDono().getId());

        categoria.setAtivo(false);

        categoriaRepository.save(categoria);
    }

}
