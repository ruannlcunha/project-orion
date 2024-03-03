package com.project_orion.api.domain;

import com.project_orion.api.domain.enums.CategoriaEnum;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Conteudo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(STRING)
    private CategoriaEnum categoria;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "biblioteca_id")
    private Biblioteca biblioteca;

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
