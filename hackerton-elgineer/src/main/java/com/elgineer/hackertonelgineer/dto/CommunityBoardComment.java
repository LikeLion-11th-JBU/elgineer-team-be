package com.elgineer.hackertonelgineer.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommunityBoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private CommunityBoardPost communityBoardPost;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public CommunityBoardComment() {
    }

    public CommunityBoardComment(Long id, String content, CommunityBoardPost communityBoardPost, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.communityBoardPost = communityBoardPost;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CommunityBoardPost getCommunityBoardPost() {
        return communityBoardPost;
    }

    public void setCommunityBoardPost(CommunityBoardPost communityBoardPost) {
        this.communityBoardPost = communityBoardPost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CommunityBoardComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", communityBoardPost=" + communityBoardPost +
                ", createdAt=" + createdAt +
                '}';
    }

}
