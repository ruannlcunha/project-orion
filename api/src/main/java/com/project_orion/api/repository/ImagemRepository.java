package com.project_orion.api.repository;

import com.project_orion.api.domain.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {

    List<Imagem> findByConteudoId(Long conteudoId);
}
