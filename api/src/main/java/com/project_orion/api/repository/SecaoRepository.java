package com.project_orion.api.repository;

import com.project_orion.api.domain.Secao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecaoRepository extends JpaRepository<Secao, Long> {

    Optional<Secao> findByIdAndAtivo(Long id, boolean ativo);
}
