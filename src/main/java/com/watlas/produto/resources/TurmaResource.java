package com.watlas.produto.resources;

import com.watlas.produto.entity.Turma;
import com.watlas.produto.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/turma")
public class TurmaResource {


    @Autowired
    private TurmaService services;

    @GetMapping(value = "/{id}")
    public Turma findById(@PathVariable Long id){
        Turma obj = services.findById(id);
        return obj;

    }
    @GetMapping
    public List<Turma> findAll(){
        List<Turma> list = services.findAll();
        return list;
    }
    @PostMapping
    public void create(@RequestBody Turma obj){
        services.create(obj);

    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Turma objDTO){
        services.update(id, objDTO);

    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);

    }
}

