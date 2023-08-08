package com.elgineer.hackertonelgineer.boards;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CommunityPostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private CommunityPost communityPost;
    // 게시글 하나에 다수의 댓글 생성가능

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public void setCommunityPost(CommunityPost communityPost){
        this.communityPost = communityPost;
        communityPost.getComments().add(this);
        //
    }

    public void communityPostRepository(CommunityPost post) {
    }

    public CommunityPostComment(Long id, String content, CommunityPost communityPost, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.communityPost = communityPost;
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

    public CommunityPost getCommunityPost() {
        return communityPost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
