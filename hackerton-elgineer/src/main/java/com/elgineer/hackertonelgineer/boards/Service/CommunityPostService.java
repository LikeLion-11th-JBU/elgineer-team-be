package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;

import java.util.List;

public interface CommunityPostService {

    // 게시글 생성
    CommunityPost createPost(CommunityPost post);

    // 전체 게시글 조회 ( 메인 게시판으로 사용할 것 )
    List<CommunityPost> getAllPosts();

    // ID로 게시글 조회
    CommunityPost getPostById(Long postId);

    // 게시글 업데이트
    CommunityPost updatePost(CommunityPost updatedPost);

    // 게시글 삭제
    void deletePost(Long postId);

    // 게시글에 댓글 추가
    CommunityPostComment addComment(Long postId, CommunityPostComment comment);

    // 게시글에 달린 댓글들 조회
    List<CommunityPostComment> getCommentsForPost(Long postId);

    // 댓글 삭제
    void deleteComment(Long commentId);

    // 게시글 좋아요 추가
    CommunityPost addLike(Long postId);

    // 게시글 좋아요 제거
    CommunityPost removeLike(Long postId);

}
