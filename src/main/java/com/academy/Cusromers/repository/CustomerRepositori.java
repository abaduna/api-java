package com.academy.Cusromers.repository;


import com.academy.Cusromers.entites.costumers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepositori  extends CrudRepository<costumers,Integer> {
    Optional<costumers> findAllById(Integer id);
}
