package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.Repository.CommunityPostCommentRepository;
import com.elgineer.hackertonelgineer.boards.Repository.CommunityPostRepository;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;
import com.elgineer.hackertonelgineer.boards.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommunityPostServiceImpl implements CommunityPostService{

    @Autowired
    private CommunityPostRepository postRepository;

    @Autowired
    private CommunityPostCommentRepository commentRepository;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public CommunityPost createPost(CommunityPost post) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            post.setWriter(loggedInUser.getNickname());
        }
        return postRepository.save(post);
    }

    @Override
    public List<CommunityPost> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public CommunityPost getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public CommunityPost updatePost(CommunityPost updatedPost) {

        if (postRepository.existsById(updatedPost.getId())) {
            return postRepository.save(updatedPost);
        }
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }


    @Override
    public List<CommunityPostComment> getCommentsForPost(Long postId) {
        Optional<CommunityPost> postOptional = postRepository.findById(postId);
        return postOptional.map(CommunityPost::getComments).orElse(null);
    }

    @Override
    public CommunityPost addLike(Long postId) {
        Optional<CommunityPost> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            CommunityPost post = postOptional.get();
            post.setLikeCount(post.getLikeCount() + 1);
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public CommunityPost removeLike(Long postId) {
        Optional<CommunityPost> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            CommunityPost post = postOptional.get();
            post.setLikeCount(Math.max(0, post.getLikeCount() - 1)); // Ensure it doesn't go below 0
            return postRepository.save(post);
        }
        return null;
    }
}
