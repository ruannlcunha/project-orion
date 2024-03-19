package com.project_orion.api.repository;

import com.project_orion.api.domain.Campanha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

    Optional<Campanha> findByIdAndAtivo(Long id, boolean ativo);

    Page<Campanha> findAllByAtivo(boolean ativo, Pageable pageable);

    Page<Campanha> findAllByUsuarioCampanhasUsuarioIdAndAtivo(Long usuarioId, boolean ativo, Pageable pageable);
}
