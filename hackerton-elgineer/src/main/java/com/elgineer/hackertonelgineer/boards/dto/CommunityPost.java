package com.elgineer.hackertonelgineer.boards.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class CommunityPost {

    @Id // id가 엔티티의 기본 키(primary key) 임을 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // DB에 자동으로 primary key 값을 생성함. (자동 증가 기능)
    private Long id;

    @Column(nullable = false)
    // title, conteny, writer 값의 null을 허용하지 않음.
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(updatable = false)
    private String writer;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "communityPost", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CommunityPostComment> comments = new ArrayList<>();

    public void addComment(CommunityPostComment comment) {
        this.comments.add(comment);
        comment.setCommunityPost(this);
    }

    public void deleteComment(CommunityPostComment comment) {
        this.comments.remove(comment);
        comment.setCommunityPost(null);
    }

    private int likeCount;

    public enum Category {
        HEALTH, EDUCATION, LIFESTYLE, FREESTYLE
    }
    @Enumerated(EnumType.STRING) // 엔티티에 카테고리 필드 추가
    private Category category;

    public CommunityPost() {
    }

    public CommunityPost(Long id, String title, String content, String writer, LocalDateTime createdAt, LocalDateTime updatedAt, List<CommunityPostComment> comments, int likeCount, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
        this.likeCount = likeCount;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<CommunityPostComment> getComments() {
        return comments;
    }

    public void setComments(List<CommunityPostComment> comments) {
        this.comments = comments;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "CommunityPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                ", likeCount=" + likeCount +
                ", category=" + category +
                '}';
    }
}
