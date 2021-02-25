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
public class MatriculaDisciplinaPessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Pessoa pessoa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private Disciplina disciplina;

    public MatriculaDisciplinaPessoa() {
    }

    public MatriculaDisciplinaPessoa(Long id, Pessoa pessoa, Disciplina disciplina) {
        this.id = id;
        this.pessoa = pessoa;
        this.disciplina = disciplina;
    }
}
