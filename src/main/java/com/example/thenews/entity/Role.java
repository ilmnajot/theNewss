package com.example.thenews.entity;

import com.example.thenews.entity.enums.Authority;
import com.example.thenews.entity.templete.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "roles")
public class Role extends AbstractEntity {

    @Column(unique = true, nullable = true)
    private String name;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(value = EnumType.STRING)
    private List<Authority> authorityList;

//
//    @Enumerated(value=EnumType.STRING)
//    private RoleType roleTypes;



}
