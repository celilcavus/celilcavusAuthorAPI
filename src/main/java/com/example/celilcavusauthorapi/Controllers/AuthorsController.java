package com.example.celilcavusauthorapi.Controllers;

import com.example.celilcavusauthorapi.Entity.Authors;
import com.example.celilcavusauthorapi.Repository.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/authors")
public class AuthorsController {

    @Autowired
    private  IAuthorRepository iAuthorRepository;

    public AuthorsController(IAuthorRepository iAuthorRepository) {
        this.iAuthorRepository = iAuthorRepository;
    }

    @GetMapping
    public Iterable<Authors> Get() {
        return iAuthorRepository.findAll();
    }


    @PostMapping
    public String Post(@RequestBody Authors authors)
    {
        iAuthorRepository.save(authors);
        return "hhello";
    }

    @PutMapping("/{id}")
    public String Put(@RequestBody Authors authors,@PathVariable("id")int id)
    {
        iAuthorRepository.findById(id).map(x->{
            x.setName(authors.getName());
    x.setSurname(authors.getSurname());
    return iAuthorRepository.save(x);
        });
        return "Update Başarili";
    }

    @GetMapping("/{id}")
    public Authors Get(@PathVariable("id") int id)
    {
        return iAuthorRepository.findById(id).get();
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") int id)
    {
        iAuthorRepository.deleteById(id);
        return "başarili";
    }
}
