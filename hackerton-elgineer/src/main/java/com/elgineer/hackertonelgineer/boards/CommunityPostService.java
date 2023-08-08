package com.elgineer.hackertonelgineer.boards;

import java.util.List;

public interface CommunityPostService {
    CommunityPost createPost(CommunityPost post);
    CommunityPost getPostById(Long postId);
    CommunityPost updatePost(CommunityPost updatePost);
    void deletePost(Long postId);

    CommunityBoardComment addComment(Long postId, CommunityBoardComment comment);
    List<CommunityBoardComment> getCommentsForPost(Long postId);
    void deleteComment(Long commentId);

    CommunityPost addLike(Long postId);
    CommunityPost removeLike(Long postId);


}
