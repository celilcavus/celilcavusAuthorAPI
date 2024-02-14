package com.example.celilcavusauthorapi.Repository;

import com.example.celilcavusauthorapi.Entity.Authors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends CrudRepository<Authors,Integer> {

}
