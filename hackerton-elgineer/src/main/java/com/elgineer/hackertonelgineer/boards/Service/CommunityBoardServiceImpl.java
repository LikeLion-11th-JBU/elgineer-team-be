package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.Repository.CommunityBoardRepository;
import com.elgineer.hackertonelgineer.boards.Repository.CommunityPostRepository;
import com.elgineer.hackertonelgineer.boards.dto.CommunityBoard;
import com.elgineer.hackertonelgineer.boards.dto.CommunityPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{

    private final CommunityBoardRepository communityBoardRepository;
    private final CommunityPostRepository communityPostRepository;

    @Autowired
    public CommunityBoardServiceImpl(CommunityBoardRepository communityBoardRepository, CommunityPostRepository communityPostRepository) {
        this.communityBoardRepository = communityBoardRepository;
        this.communityPostRepository = communityPostRepository;
    }

    @PostConstruct
    public void initialize() {
        if (communityBoardRepository.findByName("자유게시판") == null) {
            CommunityBoard mainBoard = new CommunityBoard();
            mainBoard.setName("자유게시판");
            communityBoardRepository.save(mainBoard);
        }
    }

    @Override
    public List<CommunityBoard> getAllCommunityBoards() {
        return communityBoardRepository.findAll();
    }

    @Override
    public CommunityBoard getCommunityBoardById(Long boardId) {
        return communityBoardRepository.findById(boardId).orElse(null);
    }

    @Override
    public CommunityBoard createCommunityBoard(String name) {
        return null;
    }

    @Override
    public Optional<CommunityBoard> getCommunityBoardByName(String name) {
        return communityBoardRepository.findByName(name);
    }

    @Override
    public void deleteCommunityBoard(Long boardId) {
        communityBoardRepository.deleteById(boardId);
    }

    @Override
    public List<CommunityPost> getAllPosts() {
        return communityPostRepository.findAll();
    }

    @Override
    public List<CommunityPost> getPostsByCategory(CommunityPost.Category category) {
        // CommunityPostRepository에서 카테고리 별로 조회하는 기능
        return communityPostRepository.findByCategory(category);
    }

    @Override
    public List<CommunityPost> searchPostsByKeyword(String keyword) {
        // CommunityPostRepository에서 키워드로 검색하는 기능
        return communityPostRepository.searchByKeyword(keyword);
    }
}
