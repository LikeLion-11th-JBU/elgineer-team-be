package com.elgineer.hackertonelgineer.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CommunityPostServiceImpl implements CommunityPostService{
    private final CommunityBoardRepository communityBoardRepository;
    private final CommunityPostRepository communityPostRepository;
    private final CommunityBoardCommentRepository communityBoardCommentRepository;

    @Autowired
    public CommunityPostServiceImpl(CommunityBoardRepository communityBoardRepository,
                                         CommunityPostRepository communityBoardPostRepository,
                                         CommunityBoardCommentRepository communityBoardCommentRepository) {
        this.communityBoardRepository = communityBoardRepository;
        this.communityPostRepository = communityBoardPostRepository;
        this.communityBoardCommentRepository = communityBoardCommentRepository;
    }

    // 게시글 작성
    @Override
    public CommunityPost createPost(CommunityPost post) {
        post.setCreatedAt(LocalDateTime.now());
        return communityPostRepository.save(post);
    }

    // 게시글 조회
    @Override
    public CommunityPost getPostById(Long postId) {
        return communityPostRepository.findById(postId).orElse(null);
    }

    // 게시글 업데이트
    @Override
    public CommunityPost updatePost(CommunityPost updatedPost) {
        CommunityPost existingPost = communityPostRepository.findById(updatedPost.getId())
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        existingPost.setUpdatedAt(LocalDateTime.now());

        return communityPostRepository.save(existingPost);
    }

    // 게시글 삭제
    @Override
    public void deletePost(Long postId) {
        communityPostRepository.deleteById(postId);
    }

    // 댓글 작성
    @Override
    @Transactional
    public CommunityBoardComment addComment(Long postId, CommunityBoardComment comment) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        comment.setCreatedAt(LocalDateTime.now());
        comment.communityPostRepository(post);

        return communityBoardCommentRepository.save(comment);
    }

    // 댓글 조회
    @Override
    public List<CommunityBoardComment> getCommentsForPost(Long postId) {
        return communityBoardCommentRepository.findByCommunityPostId(postId);
    }

    // 댓글 삭제
    @Override
    public void deleteComment(Long commentId) {
        CommunityBoardComment comment = communityBoardCommentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));
        communityBoardCommentRepository.delete(comment);
    }

    // 좋아요 +1
    @Override
    public CommunityPost addLike(Long postId) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        post.setLikeCount(post.getLikeCount() + 1);

        return communityPostRepository.save(post);
    }

    // 좋아요 -1
    @Override
    public CommunityPost removeLike(Long postId) {
        CommunityPost post = communityPostRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        if (post.getLikeCount() > 0) {
            post.setLikeCount(post.getLikeCount() - 1);
        }

        return communityPostRepository.save(post);
    }
}
