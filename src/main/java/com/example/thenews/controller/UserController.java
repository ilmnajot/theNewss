package com.example.thenews.controller;

import com.example.thenews.entity.User;
import com.example.thenews.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    @GetMapping
    public HttpEntity<?> getUsers(){
        return ResponseEntity.ok(userService.findUsers());
    }
}
