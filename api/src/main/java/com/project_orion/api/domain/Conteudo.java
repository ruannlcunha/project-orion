package com.project_orion.api.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Conteudo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "campanha_id")
    private Campanha campanha;

    @OneToMany(mappedBy = "conteudo")
    private List<Imagem> imagens = new ArrayList<>();

    @OneToMany(mappedBy = "conteudo")
    private List<Secao> secoes = new ArrayList<>();

    public void adicionarImagem(Imagem imagem) {
        this.imagens.add(imagem);
        imagem.setConteudo(this);
    }

    public void adicionarSecao(Secao secao) {
        this.secoes.add(secao);
        secao.setConteudo(this);
    }
}
