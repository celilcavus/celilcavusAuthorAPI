package com.example.celilcavusauthorapi.Repository;

import com.example.celilcavusauthorapi.Entity.Books;
import org.springframework.data.repository.CrudRepository;

public interface IBookRepository extends CrudRepository<Books,Integer> {
}
