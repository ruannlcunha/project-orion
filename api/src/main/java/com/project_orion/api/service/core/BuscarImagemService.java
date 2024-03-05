package com.project_orion.api.service.core;

import com.project_orion.api.domain.Imagem;
import com.project_orion.api.repository.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
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

    public String emDataUri(String nomeDoArquivo) {

        if(nomeDoArquivo.isBlank()) {
            return "";
        }

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("data/uploads/"+nomeDoArquivo).toAbsolutePath());
            String base64 = Base64.getEncoder().encodeToString(bytes);

            StringBuilder dataUri = new StringBuilder();
            dataUri.append("data:");
            dataUri.append(Files.probeContentType(Paths.get("data/uploads/"+nomeDoArquivo).toAbsolutePath()));
            dataUri.append(";base64,");
            dataUri.append(base64);
            return dataUri.toString();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
