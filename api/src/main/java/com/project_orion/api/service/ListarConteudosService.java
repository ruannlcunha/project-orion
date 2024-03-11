package com.project_orion.api.service;

import com.project_orion.api.controller.response.ConteudoMinimoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.service.core.BuscarImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project_orion.api.mapper.ConteudoMapper.toResponseMinimo;


@Service
public class ListarConteudosService {

    @Autowired
    private ConteudoRepository conteudoRepository;

    @Autowired
    private BuscarImagemService buscarImagemService;

    public List<ConteudoMinimoResponse> listar(String filtro, Long categoriaId) {

        return conteudoRepository
                .findDistinctByTituloContainsAndCategoriaIdAndAtivo(
                        filtro, categoriaId, true)
                .stream()
                .map((Conteudo conteudo) -> {
                    String imagem = buscarImagemService.emDataUri(conteudo.getImagens().get(0).getNome());
                    return toResponseMinimo(conteudo, imagem);
                })
                .collect(Collectors.toList());
    }
}
