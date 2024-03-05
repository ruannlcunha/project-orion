package com.project_orion.api.service.core;

import com.project_orion.api.domain.Campanha;
import com.project_orion.api.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class BuscarCampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public Campanha porId(Long id) {
        return campanhaRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Biblioteca não existe"));
    }


}
