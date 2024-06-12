package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.User;


import java.util.List;
import java.util.Optional;

public interface UserServices {

    Optional<User> getUsers(Integer id);

    List<User> getAllUsers();

    void AddCustumers(User users);

    void removeUsers(Integer id);

    void update(Integer id,User updateCostumers );


    List<User>  serchUsers( String email);
      /*
      default void hacerAlgo(){
          System.out.println("Hacer qalgo");
      }*/
}
