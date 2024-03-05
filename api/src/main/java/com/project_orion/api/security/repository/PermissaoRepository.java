package com.project_orion.api.security.repository;

import com.project_orion.api.security.domain.Funcao;
import com.project_orion.api.security.domain.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    boolean existsByUsuarioIdAndFuncao(Long usuarioId, Funcao funcao);

}
