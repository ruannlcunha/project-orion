package com.project_orion.api.service.core;

import com.project_orion.api.domain.Categoria;
import com.project_orion.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class BuscarCategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria porId(Long id) {
        return categoriaRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Categoria não existe"));
    }


}
