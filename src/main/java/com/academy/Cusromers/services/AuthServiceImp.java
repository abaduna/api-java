package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.User;
import com.academy.Cusromers.repository.UserRepositori;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements  AuthService {
    private static final String SECRET_KEY = "abaduna";

    @Autowired
    private UserRepositori userRepository;

    public User login(String email, String password){
        String hashPassword = Hashing.sha256()
                .hashString(password + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();


        List<User> result = userRepository.findByEmailOrAddress(email, hashPassword);
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }
}
