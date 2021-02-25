package com.watlas.produto.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn
    private Curso curso;

    @OneToMany(mappedBy = "turma")
    private List<Disciplina> disciplinas = new ArrayList<>();

}
