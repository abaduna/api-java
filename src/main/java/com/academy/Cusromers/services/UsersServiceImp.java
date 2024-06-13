package com.academy.Cusromers.services;



import com.academy.Cusromers.entites.User;

import com.academy.Cusromers.entites.costumers;
import com.academy.Cusromers.repository.UserRepositori;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  class UsersServiceImp implements UserServices {

    private static final String SECRET_KEY = "abaduna";

    @Autowired
    private UserRepositori repositori;


    public Optional<User> getUsers(Integer id){

        Optional<User>  user  = repositori.findAllById(id);
        if (user.isPresent()){
            return  user;
        }else {
            return  null;
        }
    }

    public List<User> getUser(){
        List<User> list = new ArrayList<>();
        Iterable<User> Users =repositori.findAll();
        for(User c:Users){
            list.add(c) ;
        }
        return  list;
    }

    public void AddUser(User Users){

        String hashPassword = Hashing.sha256()
                .hashString(Users.getPassword() + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();



        Users.setPassword(hashPassword);
        repositori.save(Users);
    }

    public void removeUser(Integer id){
        repositori.deleteById(id);
    }

    public void update(Integer id,User updateCostumers ){
        // list.add(Users);
        updateCostumers.setId(id);
        repositori.save(updateCostumers);
    }



}
