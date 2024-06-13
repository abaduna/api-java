package com.academy.Cusromers.controlers;


import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.entites.costumers;
import com.academy.Cusromers.repository.UserRepositori;
import com.academy.Cusromers.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserControllers {

    @Autowired
    private UserServices UserServices;

    @GetMapping("/users/{id}")
    public Optional<User> getUsers(@PathVariable Integer id){
        return UserServices.getUsers(id);

    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return   UserServices.getUser();
    }
    @PostMapping("/users") //agregar cliente
    public void register(@RequestBody User users){
        UserServices.AddUser(users);
    }
    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Integer id){
        UserServices.removeUser(id);
    }
    @PutMapping("/users/{id}") //agregar cliente
    public void update(@PathVariable Integer id,@RequestBody User updateUser ){
        // list.add(users);
        UserServices.update(id,updateUser);
    }


}
