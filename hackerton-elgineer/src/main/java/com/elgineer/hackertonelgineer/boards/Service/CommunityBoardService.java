package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.dto.CommunityBoard;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import java.util.List;
import java.util.Optional;

public interface CommunityBoardService {
    List<CommunityBoard> getAllCommunityBoards();
    CommunityBoard getCommunityBoardById(Long boardId);
    CommunityBoard createCommunityBoard(String name);
    Optional<CommunityBoard> getCommunityBoardByName(String name);
    void deleteCommunityBoard(Long boardId);
    List<CommunityPost> getAllPosts();
    List<CommunityPost> getPostsByCategory(CommunityPost.Category category);
    List<CommunityPost> searchPostsByKeyword(String keyword);
}
