package com.project_orion.api.service.core;

import com.project_orion.api.domain.Imagem;
import com.project_orion.api.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarImagemService {

    @Autowired
    private ImagemRepository conteudoImagemRepository;

    @Autowired
    private BuscarArquivoService buscarArquivoService;


    public String[] emVetorPorConteudoId(Long conteudoId) {
        List<Imagem> imagens = conteudoImagemRepository.findByConteudoId(conteudoId);
        String[] imagensArray = new String[imagens.size()];
        for(int i=0;i<imagens.size();i++) {
            imagensArray[i] = buscarArquivoService.emDataUri(imagens.get(i).getNome());
        }
        return imagensArray;
    }

}
