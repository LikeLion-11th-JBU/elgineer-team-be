package com.elgineer.hackertonelgineer.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{

    private final CommunityBoardRepository communityBoardRepository;

    @Autowired
    public CommunityBoardServiceImpl(CommunityBoardRepository communityBoardRepository){
        this.communityBoardRepository = communityBoardRepository;
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
        CommunityBoard newBoard = new CommunityBoard(name);
        return communityBoardRepository.save(newBoard);
    }

    @Override
    public void deleteCommunityBoard(Long boardId) {
        communityBoardRepository.deleteById(boardId);
    }
}
