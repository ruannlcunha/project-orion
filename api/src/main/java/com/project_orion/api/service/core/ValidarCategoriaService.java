package com.project_orion.api.service.core;

import com.project_orion.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarCategoriaService {

    private final Integer LIMITE_MAXIMO = 10;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void validarNome(String nome) {
        if(categoriaRepository.existsByNomeAndAtivo(nome, true)) {
            throw new ResponseStatusException(BAD_REQUEST, "Já existe uma categoria com esse nome.");
        }
    }

    public void validarQuantidade(Long campanhaId) {
        if(categoriaRepository.countByCampanhaIdAndAtivo(campanhaId, true).equals(LIMITE_MAXIMO)) {
            throw new ResponseStatusException(BAD_REQUEST, "O limite de 10 categorias foi atingido.");
        }
    }
}
