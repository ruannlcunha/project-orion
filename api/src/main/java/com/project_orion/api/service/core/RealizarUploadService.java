package com.project_orion.api.service.core;

import com.project_orion.api.util.Base64ToMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class RealizarUploadService {


    public String upload(String dataUri) {

        MultipartFile arquivo = new Base64ToMultipartFile(dataUri);
        try {
            if(!arquivo.isEmpty()) {
                byte[] bytes = arquivo.getBytes();
                String arquivoNome = arquivo.getOriginalFilename();
                Path caminho = Paths.get("data/uploads/"+arquivoNome).toAbsolutePath();
                Files.write(caminho, bytes);
                return arquivoNome;
            }
            else {
                throw new ResponseStatusException(BAD_REQUEST, "Houve um problema no upload do arquivo.");
            }
        }catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(BAD_REQUEST, "Houve um problema no upload do arquivo.");
        }

    }

}
