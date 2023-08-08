package com.elgineer.hackertonelgineer.boards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityBoardServiceImpl implements CommunityBoardService{

    private final CommunityBoardRepository communityBoardRepository;

    @Override
    public void createFixedCommunityBoard() {
        List<CommunityBoard> fixedBoards = new ArrayList<>();
        
        fixedBoards.add(new CommunityBoard("건강 복지 게시판"));
        fixedBoards.add(new CommunityBoard("생활 복지 게시판"));
        fixedBoards.add(new CommunityBoard("교육 복지 게시판"));
        fixedBoards.add(new CommunityBoard("자유 게시판"));

        communityBoardRepository.saveAll(fixedBoards);
    }

    @Autowired
    public CommunityBoardServiceImpl(CommunityBoardRepository communityBoardRepository){
        this.communityBoardRepository = communityBoardRepository;
    }

    // 모든 게시판을 가져오는 메서드. (전체 게시판 조회)
    //
    @Override
    public List<CommunityBoard> getAllCommunityBoards() {
        return communityBoardRepository.findAll();
    }

    // boardId 로 게시판 조회하고, 게시판이 없으면 null 반환
    // 
    @Override
    public CommunityBoard getCommunityBoardById(Long boardId) {
        return communityBoardRepository.findById(boardId).orElse(null);
    }

    // 새로운 커뮤니티 게시판을 생성하는 메서드. (나중에 수정)
    // 
    @Override
    public CommunityBoard createCommunityBoard(String name) {
        CommunityBoard newBoard = new CommunityBoard(name);
        return communityBoardRepository.save(newBoard);
    }

    // boardId 로 게시판을 삭제하는 메서드. (생성, 삭제기능 나중에 다시 수정할 것)
    //
    @Override
    public void deleteCommunityBoard(Long boardId) {
        communityBoardRepository.deleteById(boardId);
    }
}
