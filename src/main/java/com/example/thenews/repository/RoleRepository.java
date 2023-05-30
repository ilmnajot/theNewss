package com.example.thenews.repository;

import com.example.thenews.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

            Optional<Role> findByName(String Name) ;
}
