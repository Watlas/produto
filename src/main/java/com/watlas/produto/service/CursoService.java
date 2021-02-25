package com.watlas.produto.service;

import com.watlas.produto.entity.Curso;
import com.watlas.produto.repositories.CursoRepository;
import com.watlas.produto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    CursoRepository repository;

    public Curso findById(Long id){
        Optional<Curso> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + Curso.class.getName()));
    }

    public List<Curso> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Curso create(Curso obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Curso update(Long id, Curso objDTO) {
        Curso obj = findById(id);
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


