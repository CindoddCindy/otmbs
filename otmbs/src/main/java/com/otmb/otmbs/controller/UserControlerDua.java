package com.otmb.otmbs.controller;


import com.otmb.otmbs.entity.Role;
import com.otmb.otmbs.entity.User;
import com.otmb.otmbs.repository.RoleRepository;
import com.otmb.otmbs.repository.UserRepository;
import com.otmb.otmbs.service.RoleService;
import com.otmb.otmbs.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserControlerDua {

    private UserService userService;
    private UserRepository userRepository;

    public UserControlerDua(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/user/create")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return  userService.addUser(user);
    }

}
