package com.elgineer.hackertonelgineer.boards.Repository;

import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    // 나중에 게시글과 관련된 추가 기능이 필요하면 여기에 선언가능
    List<CommunityPost> findByCategory(CommunityPost.Category category);
    @Query("SELECT p FROM CommunityPost p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    List<CommunityPost> searchByKeyword(@Param("keyword") String keyword);
    // 게시글 검색 기능
}
