package com.example.thenews.entity;

import com.example.thenews.entity.templete.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
public class Comment extends AbstractEntity {

    private String text;

    @ManyToOne(fetch = FetchType.LAZY) //ko'plab commentlar bitta maqolaga tegishli
    private Post post;
}
