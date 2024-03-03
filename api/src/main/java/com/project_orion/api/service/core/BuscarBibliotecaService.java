package com.project_orion.api.service.core;

import com.project_orion.api.domain.Biblioteca;
import com.project_orion.api.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class BuscarBibliotecaService {

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Biblioteca porId(Long id) {
        return bibliotecaRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Biblioteca não existe"));
    }


}
