package com.watlas.produto.resources;

import com.watlas.produto.entity.Disciplina;
import com.watlas.produto.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaResource {


    @Autowired
    private DisciplinaService services;

    @GetMapping(value = "/{id}")
    public Disciplina findById(@PathVariable Long id){
        Disciplina obj = services.findById(id);
        return obj;

    }
    @GetMapping
    public List<Disciplina> findAll(){
        List<Disciplina> list = services.findAll();
        return list;
    }
    @PostMapping
    public void create(@RequestBody Disciplina obj){
        services.create(obj);

    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Disciplina objDTO){
        services.update(id, objDTO);

    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);

    }
}

