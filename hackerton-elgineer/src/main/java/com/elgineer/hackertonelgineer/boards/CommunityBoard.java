package com.elgineer.hackertonelgineer.boards;

import javax.persistence.*;
import java.util.List;

@Entity
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name; // 게시판 이름

    public CommunityBoard(String name) {
        this.name = name;
    }

    public CommunityBoard() {
    }

    public CommunityBoard(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CommunityBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
