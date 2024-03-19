package com.project_orion.api.repository;

import com.project_orion.api.domain.UsuarioCampanha;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioCampanhaRepository extends JpaRepository<UsuarioCampanha, Long> {

    boolean existsByUsuarioIdAndCampanhaIdAndAtivo(Long usuarioId, Long campanhaId, boolean b);
}
