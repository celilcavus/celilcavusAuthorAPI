package com.example.celilcavusauthorapi.Controllers;

import com.example.celilcavusauthorapi.Entity.Authors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AuthorsController {
    private SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = sessionFactory.openSession();
    private Transaction transaction = session.beginTransaction();

    @GetMapping
    public List<Authors> Get() {
        Query query = session.createQuery("from Authors");
        List<Authors> authors = query.getResultList();
        return authors;
    }


    @PostMapping
    public String Post(@RequestBody Authors authors)
    {
        session.save(authors);
        transaction.commit();
        session.close();
        return "hhello";
    }

    @PutMapping("/{id}")
    public String Put(@RequestBody Authors authors,@PathVariable("id")int id)
    {
        var value = session.get(Authors.class,id);
        value.setName(authors.Name);
        value.setSurname(authors.Surname);
        session.save(value);
        transaction.commit();
        session.close();
        return "Update Başarili";
    }

    @GetMapping("/{id}")
    public Authors Get(@PathVariable("id") int id)
    {
        return session.get(Authors.class,id);
    }
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") int id)
    {
        var values = session.get(Authors.class,id);
        session.delete(values);
        transaction.commit();
        session.close();
        return "başarili";
    }
}
