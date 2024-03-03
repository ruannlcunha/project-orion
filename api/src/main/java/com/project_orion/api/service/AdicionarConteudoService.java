package com.project_orion.api.service;

import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.controller.response.ConteudoResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Biblioteca;
import com.project_orion.api.domain.Conteudo;
import com.project_orion.api.domain.Imagem;
import com.project_orion.api.domain.Secao;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.repository.ImagemRepository;
import com.project_orion.api.repository.SecaoRepository;
import com.project_orion.api.service.core.BuscarBibliotecaService;
import com.project_orion.api.util.ConverterSecoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.project_orion.api.mapper.ConteudoMapper.toEntity;
import static com.project_orion.api.mapper.ConteudoMapper.toResponse;

@Service
public class AdicionarConteudoService {

    @Autowired
    ConteudoRepository conteudoRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private BuscarBibliotecaService buscarBibliotecaService;

    @Transactional
    public ConteudoResponse adicionar(ConteudoRequest request) {
        Biblioteca biblioteca = buscarBibliotecaService.porId(request.getBibliotecaId());

        Conteudo conteudo = toEntity(request);
        conteudo.setAtivo(true);
        conteudo.setImagens(new ArrayList<>());
        conteudo.setSecoes(new ArrayList<>());
        biblioteca.adicionarConteudo(conteudo);

        conteudoRepository.save(conteudo);

        adicionarImagens(request,conteudo);
        adicionarSecoes(request,conteudo);

        SecaoResponse[] secoes = ConverterSecoes.converterPorRequest(request.getSecoes());

        return toResponse(conteudo, secoes, request.getImagens());
    }

    private void adicionarImagens(ConteudoRequest request, Conteudo conteudo) {
        for(int i=0;i<request.getImagens().length;i++) {
            Imagem imagem = new Imagem();
            imagem.setNome(request.getImagens()[i]);

            conteudo.adicionarImagem(imagem);

            imagemRepository.save(imagem);
        }
    }

    private void adicionarSecoes(ConteudoRequest request, Conteudo conteudo) {
        for(int i=0;i<request.getSecoes().length;i++) {
            Secao secao = new Secao();
            secao.setTitulo(request.getSecoes()[i].getTitulo());
            secao.setDescricao(request.getSecoes()[i].getDescricao());

            conteudo.adicionarSecao(secao);

            secaoRepository.save(secao);
        }
    }

}
