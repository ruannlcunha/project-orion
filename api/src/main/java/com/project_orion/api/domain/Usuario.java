package com.project_orion.api.domain;

import com.project_orion.api.security.domain.Permissao;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private boolean ativo;

    @OneToMany(mappedBy = "dono")
    private List<Campanha> campanhasDono = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioCampanha> usuarioCampanhas = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }

    public void adicionarUsuarioCampanha(UsuarioCampanha usuarioCampanha) {
        this.usuarioCampanhas.add(usuarioCampanha);
        usuarioCampanha.setUsuario(this);
    }

}
