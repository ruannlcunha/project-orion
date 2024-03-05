package com.project_orion.api.domain;

import lombok.*;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;

    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "campanha_id")
    private Campanha campanha;

    @OneToMany(mappedBy = "categoria")
    private List<Conteudo> conteudos = new ArrayList<>();

    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
        conteudo.setCategoria(this);
    }
}
