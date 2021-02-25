package com.watlas.produto.repositories;

import com.watlas.produto.entity.MatriculaDisciplinaPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaDisciplinaPessoaRepository extends JpaRepository<MatriculaDisciplinaPessoa, Long> {
}
