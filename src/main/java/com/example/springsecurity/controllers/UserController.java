package com.example.springsecurity.controllers;

import com.example.springsecurity.entities.UserEntity;
import com.example.springsecurity.model.UserRequestModel;
import com.example.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/admin/add")
    public UserEntity addUser (@RequestBody UserRequestModel userRequest) {
        return userService.addUser(userRequest);
    }

    @GetMapping(value = "/admins")
    public String getString () {
        return "hell there";
    }


}
