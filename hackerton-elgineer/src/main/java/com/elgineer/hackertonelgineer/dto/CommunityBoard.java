package com.elgineer.hackertonelgineer.dto;

import javax.persistence.*;
import java.util.List;

@Entity
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    // 하나의 게시판에 여러개의 게시글이 속할 수 있으므로.
    // mappedBy가 양방향 매핑을 설정하기 위한 것으로, 
    // CommunityBoardPost와 CommunityBoard가 연결되어있음을 의미.
    private List<CommunityBoardPost> communityBoardPostList;

    // 게시판 이름 지정하기 위해 생성자 ㅈ
    public CommunityBoard(String name) {
        this.name = name;
    }

    public CommunityBoard() {
    }

    public CommunityBoard(Long id, String name, List<CommunityBoardPost> communityBoardPostList) {
        this.id = id;
        this.name = name;
        this.communityBoardPostList = communityBoardPostList;
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

    public List<CommunityBoardPost> getCommunityBoardPostList() {
        return communityBoardPostList;
    }

    public void setCommunityBoardPostList(List<CommunityBoardPost> communityBoardPostList) {
        this.communityBoardPostList = communityBoardPostList;
    }

    @Override
    public String toString() {
        return "CommunityBoard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", communityBoardPostList=" + communityBoardPostList +
                '}';
    }
}
