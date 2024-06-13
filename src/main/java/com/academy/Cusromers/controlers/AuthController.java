package com.academy.Cusromers.controlers;



import com.academy.Cusromers.dto.ReqLogin;
import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.services.AuthService;
import com.academy.Cusromers.utils.JDTutils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {



    @Autowired
    private AuthService service;

    @PostMapping("/auth/login")
    public String login(@RequestBody ReqLogin req) {
     User user =   service.login(req.getEmail(),req.getPassword());
       return JDTutils.generateToken(user);

    }
}