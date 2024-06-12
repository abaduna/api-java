package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.User;

public interface AuthService {

    User login(String email, String password);


}
