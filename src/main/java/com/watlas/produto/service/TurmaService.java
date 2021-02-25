package com.watlas.produto.service;

import com.watlas.produto.entity.Turma;
import com.watlas.produto.repositories.TurmaRepository;
import com.watlas.produto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    
    @Autowired
    TurmaRepository repository;

    public Turma findById(Long id){
        Optional<Turma> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + Turma.class.getName()));
    }

    public List<Turma> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Turma create(Turma obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Turma update(Long id, Turma objDTO) {
        Turma obj = findById(id);
        obj.setNome(objDTO.getNome());;
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
