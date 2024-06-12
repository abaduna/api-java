package com.academy.Cusromers.controlers;


import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.entites.costumers;
import com.academy.Cusromers.repository.UserRepositori;
import com.academy.Cusromers.services.CustomerServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserControllers {
    @Autowired
    //CustomerServices
    private UserRepositori service;

    @GetMapping("/users/{id}")
    public Optional<costumers> getUsers(@PathVariable Integer id){
        return service.getUser(id);

    }
    @GetMapping("/users")
    public List<costumers> getAllUser(){
        return   service.getAllUser();
    }
    @PostMapping("/users") //agregar cliente
    public void register(@RequestBody User users){
        service.AddUser(users);
    }
    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Integer id){
        service.removeUser(id);
    }
    @PutMapping("/users/{id}") //agregar cliente
    public void update(@PathVariable Integer id,@RequestBody costumers updateCostumers ){
        // list.add(users);
        service.update(id,updateCostumers);
    }

    @GetMapping("/users/serch")
    @CrossOrigin(origins = "*")
    public List<costumers>  serchUser(@RequestParam(name = "email",required = false) String email){
        return  service.serchUser(email);


    }
}
