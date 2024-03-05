package com.project_orion.api.repository;

import com.project_orion.api.domain.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

    Optional<Conteudo> findByIdAndAtivo(Long id, boolean ativo);

    List<Conteudo> findDistinctByTituloContainsAndCategoriaNomeAndAtivo(String filtro, String categoria, boolean ativo);

    List<Conteudo> findDistinctByTituloContainsAndAtivo(String filtro, boolean ativo);

}
