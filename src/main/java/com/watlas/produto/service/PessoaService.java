package com.watlas.produto.service;

import com.watlas.produto.entity.Pessoa;
import com.watlas.produto.repositories.PessoaRepository;
import com.watlas.produto.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa findById(Long id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + Pessoa.class.getName()));
    }

    public List<Pessoa> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Pessoa create(Pessoa obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Pessoa update(Long id, Pessoa objDTO) {
        Pessoa obj = findById(id);
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
