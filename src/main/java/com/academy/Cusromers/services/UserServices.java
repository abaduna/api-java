package com.academy.Cusromers.services;

import com.academy.Cusromers.entites.User;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


public interface UserServices {

    Optional<User> getUsers(Integer id);

    List<User> getUser();

    void AddUser(User users);

    void removeUser(Integer id);

    void update(Integer id,User updateUser );


}
