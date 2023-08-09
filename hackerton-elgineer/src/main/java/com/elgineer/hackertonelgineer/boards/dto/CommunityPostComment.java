package com.elgineer.hackertonelgineer.boards.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    @JsonBackReference
    private CommunityPost communityPost;
    // 게시글 하나에 다수의 댓글 생성가능

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = true)
    private LocalDateTime updatedAt;

    @Column(updatable = false)
    private String writer;


    public CommunityPostComment() {
    }

    public void communityPostRepository(CommunityPost post) {
    }

    public CommunityPostComment(Long id, String content, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
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
    public void setCommunityPost(CommunityPost communityPost) {
        if (this.communityPost != null) {
            // 기존 게시글에서 댓글 제거
            this.communityPost.getComments().remove(this);
        }
        this.communityPost = communityPost;
        // 새 게시글에 댓글 추가
        if (communityPost != null) {
            communityPost.getComments().add(this);
        }
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void updateContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
