package com.watlas.produto.resources;

import com.watlas.produto.entity.Curso;
import com.watlas.produto.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/curso")
public class CursoResource {


    @Autowired
    private CursoService services;

    @GetMapping(value = "/{id}")
    public Curso findById(@PathVariable Long id){
        Curso obj = services.findById(id);
        return obj;

    }
    @GetMapping
    public List<Curso> findAll(){
        List<Curso> list = services.findAll();
        return list;
    }
    @PostMapping
    public void create(@RequestBody Curso obj){
        services.create(obj);

    }
    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody Curso objDTO){
       services.update(id, objDTO);

    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        services.delete(id);

    }
}

