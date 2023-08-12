package com.elgineer.hackertonelgineer.boards.dto;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username; // ID로 사용하도록 하기

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    public User() {
    }

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }

}
