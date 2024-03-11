package com.project_orion.api.repository;

import com.project_orion.api.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByIdAndAtivo(Long id, boolean ativo);

    List<Categoria> findAllByCampanhaIdAndAtivoOrderByNome(Long usuarioId, boolean ativo);

    Integer countByCampanhaIdAndAtivo(Long campanhaId, boolean ativo);

    boolean existsByNomeAndAtivo(String nome, boolean ativo);
}
