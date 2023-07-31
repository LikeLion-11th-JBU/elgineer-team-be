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


}
