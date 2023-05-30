package com.example.thenews.controller;

import com.example.thenews.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RoleController {

    private final RoleService roleService;
    @GetMapping
    public HttpEntity<?> getRoles(){
        return ResponseEntity.ok(roleService.getRoles());

    }

}
