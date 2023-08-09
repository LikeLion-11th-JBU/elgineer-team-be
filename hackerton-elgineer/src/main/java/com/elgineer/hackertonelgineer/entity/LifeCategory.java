package com.elgineer.hackertonelgineer.entity;

import javax.persistence.*;

@Entity
public class LifeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    // 생성자, getter, setter 등 필요한 코드 작성

    // 기본 생성자
    public LifeCategory() {
    }

    // 생성자
    public LifeCategory(String name) {
        this.name = name;
    }
}
