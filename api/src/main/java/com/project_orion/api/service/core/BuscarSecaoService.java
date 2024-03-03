package com.project_orion.api.service.core;

import com.project_orion.api.domain.Secao;
import com.project_orion.api.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@Service
public class BuscarSecaoService {

    @Autowired
    private SecaoRepository secaoRepository;

    public Secao porId(Long id) {
        return secaoRepository.findByIdAndAtivo(id, true)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Seção não existe"));
    }


}
