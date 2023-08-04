package com.elgineer.hackertonelgineer.boards;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityBoardCommentRepository extends JpaRepository<CommunityBoardComment, Long> {
    List<CommunityBoardComment> findByCommunityPostId(Long postId);
    // 댓글 기능 나중에 추가할 것!
}
