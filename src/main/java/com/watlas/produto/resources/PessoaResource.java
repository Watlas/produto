package com.watlas.produto.resources;

import com.watlas.produto.entity.Pessoa;
import com.watlas.produto.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {


    @Autowired
    private PessoaService services;

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id){
        Pessoa obj = services.findById(id);
        return obj;

    }
    @GetMapping
    public List<Pessoa> findAll(){
        List<Pessoa> list = services.findAll();
        return list;
    }
    @PostMapping
    public void create(@RequestBody Pessoa obj){
        services.create(obj);

    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Pessoa objDTO){
        services.update(id, objDTO);

    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);

    }
}

