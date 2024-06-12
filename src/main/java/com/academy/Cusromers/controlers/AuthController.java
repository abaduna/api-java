package com.academy.Cusromers.controlers;



import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {



    @Autowired
    private AuthService service;

    @PostMapping("/auth/login")
    public User login(String email,String password) {
     User user =   service.login(email,password);
     return user;
    }
}