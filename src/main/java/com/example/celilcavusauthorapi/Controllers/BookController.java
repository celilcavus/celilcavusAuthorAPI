package com.example.celilcavusauthorapi.Controllers;

import com.example.celilcavusauthorapi.Entity.Books;
import com.example.celilcavusauthorapi.Repository.IBookRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
public class BookController {

    private IBookRepository iBookRepository;

    public BookController(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @GetMapping
    public Iterable<Books> Get()
    {
        return iBookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Books Get(@PathVariable("id") int id)
    {
       return iBookRepository.findById(id).get();
    }

    @PostMapping
    public int Post(@RequestBody Books books)
    {
        iBookRepository.save(books);
        return 1;
    }

    @PutMapping
    public int Put(@RequestBody Books books)
    {
        iBookRepository.findById(books.getId()).map(books1 -> {
            books1.setName(books.getName());
            books1.setPoint(books.getPoint());
            books1.setPageCount(books.getPageCount());
            books1.setAuthorId(books.getAuthorId());
            books1.setTypeId(books.getTypeId());
            iBookRepository.save(books1);
            return 1;
        });
        return 0;
    }

    @DeleteMapping("/{id}")
    public int Delete(@PathVariable("id")int id)
    {
        iBookRepository.deleteById(id);
        return 1;
    }
}
