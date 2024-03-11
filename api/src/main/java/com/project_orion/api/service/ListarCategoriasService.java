package com.project_orion.api.service;

import com.project_orion.api.controller.response.CategoriaResponse;
import com.project_orion.api.mapper.CategoriaMapper;
import com.project_orion.api.repository.CategoriaRepository;
import com.project_orion.api.security.service.UsuarioAutenticadoService;
import com.project_orion.api.service.core.BuscarImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarCategoriasService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarImagemService buscarImagemService;

    public List<CategoriaResponse> listar(Long campanhaId) {
        Long usuarioId = usuarioAutenticadoService.getId();

        return categoriaRepository.findAllByCampanhaIdAndAtivoOrderByNome(usuarioId, true)
                .stream()
                .map(CategoriaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
