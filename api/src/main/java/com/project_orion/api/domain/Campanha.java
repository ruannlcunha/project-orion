package com.project_orion.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Campanha {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    private String imagemFundo;

    private String imagemIcone;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario dono;

    private boolean ativo;

    @OneToMany(mappedBy = "campanha")
    private List<Conteudo> conteudos = new ArrayList<>();

    @OneToMany(mappedBy = "campanha")
    private List<Categoria> categorias = new ArrayList<>();

    @OneToMany(mappedBy = "campanha")
    private List<UsuarioCampanha> usuarioCampanhas = new ArrayList<>();

    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
        conteudo.setCampanha(this);
    }

    public void adicionarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
        categoria.setCampanha(this);
    }

    public void adicionarUsuarioCampanha(UsuarioCampanha usuarioCampanha) {
        this.usuarioCampanhas.add(usuarioCampanha);
        usuarioCampanha.setCampanha(this);
    }
}
