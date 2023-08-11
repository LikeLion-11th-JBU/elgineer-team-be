package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;

import java.util.List;

public interface CommunityPostCommentService {

    // 댓글 생성
    CommunityPostComment createComment(CommunityPostComment comment, Long postId);

    // 댓글 조회
    CommunityPostComment getCommentById(Long commentId);

    // 특정 게시글의 모든 댓글 조회
    List<CommunityPostComment> getAllCommentsByPostId(Long postId);

    // 댓글 업데이트
    CommunityPostComment updateComment(Long commentId, String content);

    // 댓글 삭제
    void deleteComment(Long commentId);
}
