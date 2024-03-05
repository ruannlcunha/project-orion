package com.project_orion.api.controller;

import com.project_orion.api.controller.request.UsuarioRequest;
import com.project_orion.api.service.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping
    public void cadastrar(@Valid @RequestBody UsuarioRequest request) {
        cadastrarUsuarioService.cadastrar(request);
    }


}
