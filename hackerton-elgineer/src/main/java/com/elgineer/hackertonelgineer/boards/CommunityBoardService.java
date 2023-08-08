package com.elgineer.hackertonelgineer.boards;

import java.util.List;

public interface CommunityBoardService {
    List<CommunityBoard> getAllCommunityBoards();
    CommunityBoard getCommunityBoardById(Long boardId);
    CommunityBoard createCommunityBoard(String name);
    CommunityBoard getCommunityBoardByName(String name);
    void deleteCommunityBoard(Long boardId);
    List<CommunityPost> getAllPosts();
    List<CommunityPost> getPostsByCategory(CommunityPost.Category category);
    List<CommunityPost> searchPostsByKeyword(String keyword);
}
