package com.project_orion.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Campanha {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    @OneToMany(mappedBy = "campanha")
    private List<ConteudoCampanha> conteudoCampanha = new ArrayList<>();

    public void adicionarConteudo(ConteudoCampanha conteudoCampanha) {
        this.conteudoCampanha.add(conteudoCampanha);
        conteudoCampanha.setCampanha(this);
    }

}
