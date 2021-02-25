package com.watlas.produto.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Turma turma;

    @OneToMany(mappedBy = "disciplina")
    private List<MatriculaDisciplinaPessoa> matriculaDisciplinaPessoas = new ArrayList<>();

    public Disciplina() {
    }

    public Disciplina(Long id, String nome, Turma turma) {
        this.id = id;
        this.nome = nome;
        this.turma = turma;
    }
}
