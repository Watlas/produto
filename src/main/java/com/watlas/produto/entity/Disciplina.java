package com.watlas.produto.entity;


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

    @ManyToOne
    @JoinColumn
    private Turma turma;

    @OneToMany(mappedBy = "disciplina")
    private List<MatriculaDisciplinaPessoa> matriculaDisciplinaPessoas = new ArrayList<>();




}
