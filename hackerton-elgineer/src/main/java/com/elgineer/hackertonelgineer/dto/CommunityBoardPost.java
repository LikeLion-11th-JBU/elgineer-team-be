package com.elgineer.hackertonelgineer.dto;


import jdk.jfr.Category;
import lombok.Data;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.List;

@Entity // DB 테이블과 매핑되는 엔티티 클래스임을 JPA에게 알랴줌
@Data //
public class CommunityBoardPost {

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
    // 여러 개의 게시글이 하나의 카테고리에 속할 수 있으므로.
    // Fetch..=> 지연 로딩을 의미, 실제로 데이터가 필요한 시점에 DB에서 가져옴
    @JoinColumn(name = "category_id")
    // foreign key 를 지정할 때 사용되고, 이 foreign key의 이름을 category_id 로 지정함
    private Category category;
    //

    @Column(nullable = false, updatable = false)
    // createAt은 값을 비울 수 없고, 값을 수정할 수 없음.
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<Comment> comments;

    private int likeCount;

    public CommunityBoardPost() {
    }

    public CommunityBoardPost(Long id, String title, String content, String writer, Category category, LocalDateTime createdAt, LocalDateTime updatedAt, List<Comment> comments, int likeCount) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
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
        return "CommunityBoardPost{" +
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
