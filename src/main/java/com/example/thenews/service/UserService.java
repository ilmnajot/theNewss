package com.example.thenews.service;

import com.example.thenews.entity.User;
import com.example.thenews.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
