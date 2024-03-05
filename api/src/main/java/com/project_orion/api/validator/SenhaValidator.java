package com.project_orion.api.validator;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Component
public class SenhaValidator {

    public void validar(String senha, String confirmacaoSenha){
        if(!senha.equals(confirmacaoSenha)){
            throw new ResponseStatusException(BAD_REQUEST, "A confirmação de senha está diferente.");
        };
    }

}
