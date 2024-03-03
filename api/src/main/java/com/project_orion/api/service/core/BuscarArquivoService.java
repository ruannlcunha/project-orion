package com.project_orion.api.service.core;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class BuscarArquivoService {


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
