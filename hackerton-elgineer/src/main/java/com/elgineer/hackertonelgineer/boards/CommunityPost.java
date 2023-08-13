package com.elgineer.hackertonelgineer.boards;

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

    @Column(nullable = false)
    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    // foreign key 를 지정할 때 사용되고, 이 foreign key의 이름을 category_id 로 지정함
    // 게시글이 어느 카테고리에 속하는지 표시하는데 사용됨.
    private CommunityBoard category;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    // createAt은 값을 비울 수 없고, 값을 수정할 수 없음.
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "communityPost", cascade = CascadeType.ALL, orphanRemoval = true)
    //
    private List<CommunityBoardComment> comments = new ArrayList<>();

    private int likeCount;

    public CommunityPost() {
    }

    public CommunityPost(Long id, String title, String content, String writer, CommunityBoard category, LocalDateTime createdAt, LocalDateTime updatedAt, List<CommunityBoardComment> comments, int likeCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
        this.likeCount = likeCount;
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

    public CommunityBoard getCategory() {
        return category;
    }

    public void setCategory(CommunityBoard category) {
        this.category = category;
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

    public List<CommunityBoardComment> getComments() {
        return comments;
    }

    public void setComments(List<CommunityBoardComment> comments) {
        this.comments = comments;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public String toString() {
        return "CommunityPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", category=" + category +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                ", likeCount=" + likeCount +
                '}';
    }
}