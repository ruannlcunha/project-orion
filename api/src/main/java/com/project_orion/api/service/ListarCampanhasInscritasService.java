package com.project_orion.api.service;

import com.project_orion.api.controller.response.CampanhaResponse;
import com.project_orion.api.mapper.CampanhaMapper;
import com.project_orion.api.repository.CampanhaRepository;
import com.project_orion.api.security.service.UsuarioAutenticadoService;
import com.project_orion.api.service.core.BuscarImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarCampanhasInscritasService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarImagemService buscarImagemService;

    public Page<CampanhaResponse> listar(Pageable pageable) {
        Long usuarioId = usuarioAutenticadoService.getId();

        return campanhaRepository.findAllByUsuarioCampanhasUsuarioIdAndAtivo(usuarioId, true, pageable)
                .map(entity -> {
                    String imagemFundoUri = buscarImagemService.emDataUri(entity.getImagemFundo());
                    String imagemIconeUri = buscarImagemService.emDataUri(entity.getImagemIcone());
                    return CampanhaMapper.toResponse(entity, imagemFundoUri, imagemIconeUri);
                });
    }
}
