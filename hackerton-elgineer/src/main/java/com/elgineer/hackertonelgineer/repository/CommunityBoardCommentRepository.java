package com.elgineer.hackertonelgineer.repository;

import com.elgineer.hackertonelgineer.dto.CommunityBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityBoardCommentRepository extends JpaRepository<CommunityBoardComment, Long> {
    List<CommunityBoardComment> findByCommunityBoardPostId(Long postId);
}
