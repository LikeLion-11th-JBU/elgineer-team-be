package com.elgineer.hackertonelgineer.boards.Service;



import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;

import com.elgineer.hackertonelgineer.boards.dto.CommunityPostComment;

import java.util.List;

public interface CommunityPostService {
    CommunityPost createPost(CommunityPost post, String boardName);
    List<CommunityPost> getAllPosts();
    CommunityPost getPostById(Long postId);
    CommunityPost updatePost(CommunityPost updatePost);
    void deletePost(Long postId);

    CommunityPostComment addComment(Long postId, CommunityPostComment comment);
    List<CommunityPostComment> getCommentsForPost(Long postId);
    void deleteComment(Long commentId);
    CommunityPost addLike(Long postId);
    CommunityPost removeLike(Long postId);


}
