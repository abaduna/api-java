package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.User;
import org.springframework.stereotype.Service;


public interface AuthService {

    User login(String email, String password);


}
