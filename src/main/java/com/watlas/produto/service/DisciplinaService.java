package com.watlas.produto.service;

import com.watlas.produto.entity.Disciplina;
import com.watlas.produto.repositories.DisciplinaRepository;
import com.watlas.produto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository repository;

    public Disciplina findById(Long id){
        Optional<Disciplina> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + Disciplina.class.getName()));
    }

    public List<Disciplina> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Disciplina create(Disciplina obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Disciplina update(Long id, Disciplina objDTO) {
        Disciplina obj = findById(id);
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
