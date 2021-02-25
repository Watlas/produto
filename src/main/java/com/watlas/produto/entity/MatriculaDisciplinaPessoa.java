package com.watlas.produto.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class MatriculaDisciplinaPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn
    private Disciplina disciplina;

}
