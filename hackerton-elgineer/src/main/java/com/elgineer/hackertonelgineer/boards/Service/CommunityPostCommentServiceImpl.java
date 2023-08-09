package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.Repository.CommunityPostCommentRepository;
import com.elgineer.hackertonelgineer.boards.Repository.CommunityPostRepository;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class CommunityPostCommentServiceImpl implements CommunityPostCommentService {
    @Autowired
    private CommunityPostRepository postRepository;

    @Autowired
    private CommunityPostCommentRepository communityPostCommentRepository;


    @Autowired
    private CommunityPostCommentRepository commentRepository;

    @Override
    public CommunityPostComment createComment(CommunityPostComment comment, Long postId) {
        Optional<CommunityPost> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            CommunityPost post = postOptional.get();
            post.addComment(comment);
            return commentRepository.save(comment);
        }
        return null;
    }

    @Override
    public CommunityPostComment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    @Override
    public List<CommunityPostComment> getAllCommentsByPostId(Long postId) {
        Optional<CommunityPost> postOptional = postRepository.findById(postId);
        return postOptional.map(CommunityPost::getComments).orElse(null);
    }

    @Transactional
    @Override
    public CommunityPostComment updateComment(Long commentId, String content) {
        CommunityPostComment comment = commentRepository.findById(commentId).orElseThrow(()
                -> new IllegalArgumentException("Invalid Comment ID"));
        comment.updateContent(content);
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
