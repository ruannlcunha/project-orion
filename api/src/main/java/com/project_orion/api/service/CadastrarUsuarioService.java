package com.project_orion.api.service;

import com.project_orion.api.controller.request.UsuarioRequest;
import com.project_orion.api.domain.Usuario;
import com.project_orion.api.repository.UsuarioRepository;
import com.project_orion.api.security.service.PermissaoPadraoService;
import com.project_orion.api.security.service.SenhaCriptografadaService;
import com.project_orion.api.service.core.ValidaAtributoUnicoService;
import com.project_orion.api.validator.SenhaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project_orion.api.mapper.UsuarioMapper.toEntity;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SenhaCriptografadaService senhaCriptografadaService;

    @Autowired
    private PermissaoPadraoService permissaoPadraoService;

    @Autowired
    private ValidaAtributoUnicoService validaAtributoUnicoService;

    @Autowired
    private SenhaValidator senhaValidator;

    @Transactional
    public void cadastrar(UsuarioRequest request) {
        validaAtributoUnicoService.validarNome(request.getNome());
        validaAtributoUnicoService.validarEmail(request.getEmail());
        senhaValidator.validar(request.getSenha(), request.getConfirmacaoDeSenha());

        Usuario usuario = toEntity(request);
        usuario.setSenha(senhaCriptografadaService.get(request.getSenha()));
        usuario.adicionarPermissao(permissaoPadraoService.get());
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);
    }
}
