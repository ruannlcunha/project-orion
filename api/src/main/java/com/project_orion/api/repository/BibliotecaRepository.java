package com.project_orion.api.repository;

import com.project_orion.api.domain.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

    Optional<Biblioteca> findByIdAndAtivo(Long id, boolean ativo);
}
