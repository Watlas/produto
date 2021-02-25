package com.watlas.produto.service;

import com.watlas.produto.entity.MatriculaDisciplinaPessoa;
import com.watlas.produto.repositories.MatriculaDisciplinaPessoaRepository;
import com.watlas.produto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaDisciplinaPessoaService {
    
    @Autowired
    MatriculaDisciplinaPessoaRepository repository;

    public MatriculaDisciplinaPessoa findById(Long id){
        Optional<MatriculaDisciplinaPessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + MatriculaDisciplinaPessoa.class.getName()));
    }

    public List<MatriculaDisciplinaPessoa> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public MatriculaDisciplinaPessoa create(MatriculaDisciplinaPessoa obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public MatriculaDisciplinaPessoa update(Long id, MatriculaDisciplinaPessoa objDTO) {
        MatriculaDisciplinaPessoa obj = findById(id);
        obj.setPessoa(objDTO.getPessoa());;
        obj.setDisciplina(objDTO.getDisciplina());
        return repository.save(obj);
    }

    public void delete(Long id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){

        }
    }
}
