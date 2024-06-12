package com.academy.Cusromers.repository;



import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.entites.costumers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositori  extends CrudRepository<User,Integer> {
    Optional<User> findAllById(Integer id);

    @Query("SELECT c FROM User c WHERE c.email LIKE %:email%")
    List<User> findByEmailOrAddress(@Param("email") String email);

    @Query("SELECT c FROM User c WHERE c.email = :email AND c.password = :password")
    List<User> findByEmailsAndPassword(@Param("email") String email,@Param("password") String password);


}
