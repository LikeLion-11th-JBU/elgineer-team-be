package com.elgineer.hackertonelgineer.boards.Repository;

import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityPostCommentRepository extends JpaRepository<CommunityPostComment, Long> {
    List<CommunityPostComment> findByCommunityPostId(Long postId);
    // 댓글 기능 나중에 추가할 것!
}
