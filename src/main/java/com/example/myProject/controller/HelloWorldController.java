package com.example.myProject.controller;


import com.example.myProject.dao.UserRepository;
import com.example.myProject.entity.User;
import com.example.myProject.utils.properties.NeoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/5/5.
 */
@RestController
public class HelloWorldController {

    @Autowired
    NeoProperties properties;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello")
    public String index() {

        User user = userRepository.findByUserName("aa1");

        return user.toString();
    }
}
