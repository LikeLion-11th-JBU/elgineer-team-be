package com.elgineer.hackertonelgineer.service;

import com.elgineer.hackertonelgineer.dto.CommunityBoard;
import com.elgineer.hackertonelgineer.dto.CommunityBoardComment;
import com.elgineer.hackertonelgineer.dto.CommunityBoardPost;
import com.elgineer.hackertonelgineer.repository.CommunityBoardCommentRepository;
import com.elgineer.hackertonelgineer.repository.CommunityBoardPostRepository;
import com.elgineer.hackertonelgineer.repository.CommunityBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommunityBoardPostService {

    private final CommunityBoardRepository communityBoardRepository;
    private final CommunityBoardPostRepository communityBoardPostRepository;
    private final CommunityBoardCommentRepository communityBoardCommentRepository;

    @Autowired
    public CommunityBoardPostService(CommunityBoardRepository communityBoardRepository,
                                     CommunityBoardPostRepository communityBoardPostRepository,
                                     CommunityBoardCommentRepository communityBoardCommentRepository){
        this.communityBoardRepository = communityBoardRepository;
        this.communityBoardPostRepository = communityBoardPostRepository;
        this.communityBoardCommentRepository = communityBoardCommentRepository;
    }

    // 게시글 작성
    public CommunityBoardPost createPost(CommunityBoardPost post) {
        post.setCreatedAt(LocalDateTime.now());
        return communityBoardPostRepository.save(post);
    }

    // 게시글 조회
    public CommunityBoardPost getPostById(Long postId) {
        return communityBoardPostRepository.findById(postId).orElse(null);
    }

    // 게시글 수정
    public CommunityBoardPost updatePost(CommunityBoardPost updatedPost) {
        CommunityBoardPost existingPost = communityBoardPostRepository.findById(updatedPost.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());

        return communityBoardPostRepository.save(existingPost);
    }

    // 게시글 삭제
    public void deletePost(Long postId) {
        communityBoardPostRepository.deleteById(postId);
    }

    // 댓글 추가
    @Transactional
    public CommunityBoardComment addComment(CommunityBoardPost post, CommunityBoardComment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        comment.setCommunityBoardPost(post);
        return communityBoardCommentRepository.save(comment);
    }

    // 댓글 삭제
    public void deleteComment(Long commentId) {
        communityBoardCommentRepository.deleteById(commentId);
    }

    // 댓글 조회
    public List<CommunityBoardComment> getCommentsForPost(Long postId) {
        return communityBoardCommentRepository.findByCommunityBoardPostId(postId);
    }

    // 좋아요 추가
    public CommunityBoardPost addLike(Long postId) {
        CommunityBoardPost post = communityBoardPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setLikeCount(post.getLikeCount() + 1);

        return communityBoardPostRepository.save(post);
    }

    // 좋아요 취소
    public CommunityBoardPost removeLike(Long postId) {
        CommunityBoardPost post = communityBoardPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (post.getLikeCount() > 0) {
            post.setLikeCount(post.getLikeCount() - 1);
        }

        return communityBoardPostRepository.save(post);
    }

}
