package com.project_orion.api.service;

import com.project_orion.api.domain.Campanha;
import com.project_orion.api.domain.Usuario;
import com.project_orion.api.domain.UsuarioCampanha;
import com.project_orion.api.repository.UsuarioCampanhaRepository;
import com.project_orion.api.security.service.UsuarioAutenticadoService;
import com.project_orion.api.service.core.BuscarCampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.project_orion.api.domain.enums.Cargo.ESPECTADOR;

@Service
public class InscreverCampanhaService {

    @Autowired
    private UsuarioCampanhaRepository usuarioCampanhaRepository;

    @Autowired
    private BuscarCampanhaService buscarCampanhaService;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void inscrever(Long campanhaId) {
        Usuario usuario = usuarioAutenticadoService.get();
        Campanha campanha = buscarCampanhaService.porId(campanhaId);

        UsuarioCampanha usuarioCampanha = new UsuarioCampanha();
        usuarioCampanha.setCargo(ESPECTADOR);
        usuario.adicionarUsuarioCampanha(usuarioCampanha);
        campanha.adicionarUsuarioCampanha(usuarioCampanha);
        usuarioCampanhaRepository.save(usuarioCampanha);
    }
}
