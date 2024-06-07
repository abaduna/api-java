package com.academy.Cusromers.repository;


import com.academy.Cusromers.entites.costumers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepositori  extends CrudRepository<costumers,Integer> {
    Optional<costumers> findAllById(Integer id);

    @Query("SELECT c FROM costumers c WHERE c.email LIKE %:email%")
    List<costumers> findByEmailOrAddress(@Param("email") String email);
}
