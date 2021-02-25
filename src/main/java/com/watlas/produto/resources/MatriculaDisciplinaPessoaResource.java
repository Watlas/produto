package com.watlas.produto.resources;

import com.watlas.produto.entity.MatriculaDisciplinaPessoa;
import com.watlas.produto.service.MatriculaDisciplinaPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/matriculadisciplinapessoa")
public class MatriculaDisciplinaPessoaResource {


    @Autowired
    private MatriculaDisciplinaPessoaService services;

    @GetMapping(value = "/{id}")
    public MatriculaDisciplinaPessoa findById(@PathVariable Long id){
        MatriculaDisciplinaPessoa obj = services.findById(id);
        return obj;

    }
    @GetMapping
    public List<MatriculaDisciplinaPessoa> findAll(){
        List<MatriculaDisciplinaPessoa> list = services.findAll();
        return list;
    }
    @PostMapping
    public void create(@RequestBody MatriculaDisciplinaPessoa obj){
        services.create(obj);

    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody MatriculaDisciplinaPessoa objDTO){
        services.update(id, objDTO);

    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);

    }
}

