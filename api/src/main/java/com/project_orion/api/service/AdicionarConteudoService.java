package com.project_orion.api.service;

import com.project_orion.api.controller.request.ConteudoRequest;
import com.project_orion.api.domain.*;
import com.project_orion.api.repository.ConteudoRepository;
import com.project_orion.api.repository.ImagemRepository;
import com.project_orion.api.repository.SecaoRepository;
import com.project_orion.api.service.core.BuscarCampanhaService;
import com.project_orion.api.service.core.BuscarCategoriaService;
import com.project_orion.api.service.core.RealizarUploadService;
import com.project_orion.api.service.core.ValidarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static com.project_orion.api.mapper.ConteudoMapper.toEntity;

@Service
public class AdicionarConteudoService {

    @Autowired
    ConteudoRepository conteudoRepository;

    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private SecaoRepository secaoRepository;

    @Autowired
    private RealizarUploadService realizarUploadService;

    @Autowired
    private BuscarCampanhaService buscarCampanhaService;

    @Autowired
    private BuscarCategoriaService buscarCategoriaService;

    @Autowired
    private ValidarUsuarioService validarUsuarioService;

    @Transactional
    public void adicionar(ConteudoRequest request) {
        Campanha campanha = buscarCampanhaService.porId(request.getCampanhaId());
        Categoria categoria = buscarCategoriaService.porId(request.getCategoriaId());
        validarUsuarioService.validarDono(categoria.getCampanha().getDono().getId());

        Conteudo conteudo = toEntity(request);
        conteudo.setAtivo(true);
        conteudo.setImagens(new ArrayList<>());
        conteudo.setSecoes(new ArrayList<>());
        categoria.adicionarConteudo(conteudo);
        campanha.adicionarConteudo(conteudo);

        conteudoRepository.save(conteudo);

        salvarImagens(request,conteudo);
        salvarSecoes(request,conteudo);
    }

    private void salvarImagens(ConteudoRequest request, Conteudo conteudo) {
        for(int i=0;i<request.getImagens().length;i++) {
            Imagem imagem = new Imagem();
            String nomeDoArquivo = realizarUploadService.upload(request.getImagens()[i]);
            imagem.setNome(nomeDoArquivo);

            conteudo.adicionarImagem(imagem);

            imagemRepository.save(imagem);
        }
    }

    private void salvarSecoes(ConteudoRequest request, Conteudo conteudo) {
        for(int i=0;i<request.getSecoes().length;i++) {
            Secao secao = new Secao();
            secao.setTitulo(request.getSecoes()[i].getTitulo());
            secao.setDescricao(request.getSecoes()[i].getDescricao());

            conteudo.adicionarSecao(secao);

            secaoRepository.save(secao);
        }
    }

}
