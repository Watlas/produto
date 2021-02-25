package com.watlas.produto.service;

import com.watlas.produto.entity.*;
import com.watlas.produto.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DisciplinaRepository disciplinaService;

    @Autowired
    private MatriculaDisciplinaPessoaRepository matriculaDisciplinaPessoaService;

    @Autowired
    private PessoaRepository pessoaService;

    @Autowired
    private TurmaRepository turmaService;

    public void instanciaBaseDeDados() {

        Curso c1 = new Curso(null, "ADS");
        Curso c2 = new Curso(null, "ANALISTA DE DADOS");
        Curso c3 = new Curso(null, "ADVOGADO");

        Turma t1 = new Turma(null, "Turma 1", c1);
        Turma t2 = new Turma(null, "Turma 2", c2);
        Turma t3 = new Turma(null, "Turma 3", c3);

        Disciplina d1 = new Disciplina(null, "Criação de sites", t1);
        Disciplina d2 = new Disciplina(null, "Criação de sites", t2);
        Disciplina d3 = new Disciplina(null, "Criação de sites", t3);

        Pessoa p1 = new Pessoa(null, "Watlas");
        Pessoa p2 = new Pessoa(null, "Joao");
        Pessoa p3 = new Pessoa(null, "Luana");

        MatriculaDisciplinaPessoa mdp1 = new MatriculaDisciplinaPessoa(null, p1, d1);
        MatriculaDisciplinaPessoa mdp2 = new MatriculaDisciplinaPessoa(null, p2, d2);
        MatriculaDisciplinaPessoa mdp3 = new MatriculaDisciplinaPessoa(null, p3, d3);

        cursoRepository.save(c1);
        cursoRepository.save(c2);
        cursoRepository.save(c3);

        turmaService.save(t1);
        turmaService.save(t2);
        turmaService.save(t3);

        disciplinaService.save(d1);
        disciplinaService.save(d2);
        disciplinaService.save(d3);

        pessoaService.save(p1);
        pessoaService.save(p2);
        pessoaService.save(p3);

        matriculaDisciplinaPessoaService.save(mdp1);
        matriculaDisciplinaPessoaService.save(mdp2);
        matriculaDisciplinaPessoaService.save(mdp3);

    }

}
