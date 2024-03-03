package com.project_orion.api.service;

import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.domain.enums.CategoriaEnum;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.service.core.BuscarImagemService;
import com.project_orion.api.util.ConverterSecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project_orion.api.mapper.ConteudoMapper.toResponse;


@Service
public class ListarConteudosService {

    @Autowired
    private ConteudoRepository conteudoRepository;

    @Autowired
    private BuscarImagemService buscarImagemService;

    public List<ConteudoResponse> listar(String filtro, String categoria) {

        if(categoria.isBlank()) {
            return listarSemCategoria(filtro);
        }

        return listarComCategoria(filtro, categoria);
    }

    private List<ConteudoResponse> listarComCategoria(String filtro, String categoria) {
        return conteudoRepository
                .findDistinctByTituloContainsAndCategoriaAndAtivo(
                        filtro, CategoriaEnum.valueOf(categoria), true)
                .stream()
                .map((Conteudo conteudo) -> {
                    SecaoResponse[] secoes = ConverterSecoes.converterPorList(conteudo.getSecoes());
                    String[] imagens = buscarImagemService.emVetorPorConteudoId(conteudo.getId());
                    return toResponse(conteudo, secoes, imagens);
                })
                .collect(Collectors.toList());
    }

    private List<ConteudoResponse> listarSemCategoria(String filtro) {
        return conteudoRepository
                .findDistinctByTituloContainsAndAtivo(
                        filtro, true)
                .stream()
                .map((Conteudo conteudo) -> {
                    SecaoResponse[] secoes = ConverterSecoes.converterPorList(conteudo.getSecoes());
                    String[] imagens = buscarImagemService.emVetorPorConteudoId(conteudo.getId());
                    return toResponse(conteudo, secoes, imagens);
                })
                .collect(Collectors.toList());
    }

}
