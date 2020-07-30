package com.example.datajpa.controller;

import com.example.datajpa.entity.User;
import com.example.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @program: data-jpa
 * @description: ${description}
 * @author: Mr.ZeroCamel
 * @create: 2020-07-30 22:24
 **/
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id)
    {
        User one = userRepository.getOne(id);
        return one;
    }

    @GetMapping("/user")
    public User insertUser(User user)
    {
        User save = userRepository.save(user);
        return save;
    }

}
