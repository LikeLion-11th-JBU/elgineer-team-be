package com.elgineer.hackertonelgineer.boards.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name; // 게시판 이름

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    // 여러 개의 게시글이 하나의 게시판에 속하도록
    private List<CommunityPost> posts = new ArrayList<>();

    public CommunityBoard(String name) {
        this.name = name;
    }

    public CommunityBoard() {
    }

    public CommunityBoard(Long id, String name, List<CommunityPost> posts) {
        this.id = id;
        this.name = name;
        this.posts = posts;
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

    public List<CommunityPost> getPosts() {
        return posts;
    }

    public void setPosts(List<CommunityPost> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "CommunityBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }
}
