package com.project_orion.api.service.core;

import com.project_orion.api.controller.response.ImagemResponse;
import com.project_orion.api.controller.response.SecaoResponse;
import com.project_orion.api.domain.Imagem;
import com.project_orion.api.domain.Secao;
import com.project_orion.api.mapper.ImagemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project_orion.api.mapper.SecaoMapper.toResponse;

@Service
public class ConverterListasService {

    @Autowired
    private BuscarImagemService buscarImagemService;

    public SecaoResponse[] converterSecoes(List<Secao> arrayList) {
        SecaoResponse[] secoes = new SecaoResponse[arrayList.size()];

        for(int i=0;i<secoes.length;i++) {
            Secao secao = new Secao();
            secao.setId(arrayList.get(i).getId());
            secao.setTitulo(arrayList.get(i).getTitulo());
            secao.setDescricao(arrayList.get(i).getDescricao());

            secoes[i] = toResponse(secao);
        }
        return secoes;
    }

    public ImagemResponse[] converterImagens(List<Imagem> arrayList) {
        ImagemResponse[] imagens = new ImagemResponse[arrayList.size()];

        for(int i=0;i<imagens.length;i++) {
            Imagem imagem = new Imagem();
            imagem.setId(arrayList.get(i).getId());
            imagem.setNome(arrayList.get(i).getNome());
            String dataUri = buscarImagemService.emDataUri(imagem.getNome());

            imagens[i] = ImagemMapper.toResponse(imagem, dataUri);
        }
        return imagens;
    }

}
