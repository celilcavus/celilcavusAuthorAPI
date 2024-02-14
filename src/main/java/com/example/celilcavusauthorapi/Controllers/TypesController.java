package com.example.celilcavusauthorapi.Controllers;

import com.example.celilcavusauthorapi.Entity.Types;

import com.example.celilcavusauthorapi.Repository.ITypeRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypesController {
    private ITypeRepository iTypeRepository;

    public TypesController(ITypeRepository iTypeRepository) {
        this.iTypeRepository = iTypeRepository;
    }

    @GetMapping
    public Iterable<Types> Get()
    {
       return iTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Types Get(@PathVariable("id") int id)
    {
        return iTypeRepository.findById(id).get();
    }

    @PostMapping
    public int Post(@RequestBody Types types)
    {
        iTypeRepository.save(types);
        return 1;
    }

    @DeleteMapping("/{id}")
    public int Delete(@PathVariable("id") int id)
    {
        iTypeRepository.deleteById(id);
        return 1;
    }

    @PutMapping("/{id}")
    public int Put(@RequestBody Types types,@PathVariable("id") int id)
    {
        iTypeRepository.findById(id).map(types1 -> {
            types1.setName(types.getName());
            return iTypeRepository.save(types1);
        });
        return 1;
    }
}
