package com.elgineer.hackertonelgineer.service;


import com.elgineer.hackertonelgineer.dto.CommunityBoard;
import com.elgineer.hackertonelgineer.repository.CommunityBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityBoardService implements CommunityBoardLogic {

    private final CommunityBoardRepository communityBoardRepository;

    @Autowired
    public CommunityBoardService(CommunityBoardRepository communityBoardRepository) {
        this.communityBoardRepository = communityBoardRepository;
    }

    // CommunityBoard에 미리 게시판을 생성해놓고,
    // 각 카테고리마다 게시글을 작성할 수 있도록 할 예정

    /*
    // 애플리케이션 시작 시점에 미리 4개의 게시판을 생성해놓도록 함
    public void run(String... args){
        createFixedCommunityBoard();
    }*/

    @Override
    public void createFixedCommunityBoard() {
        List<CommunityBoard> fixedBoards = new ArrayList<>();
        
        fixedBoards.add(new CommunityBoard("건강 복지 게시판"));
        fixedBoards.add(new CommunityBoard("생활 복지 게시판"));
        fixedBoards.add(new CommunityBoard("교육 복지 게시판"));
        fixedBoards.add(new CommunityBoard("자유 게시판"));

        communityBoardRepository.saveAll(fixedBoards);
    }

    // 전체 커뮤니티 게시판 조회
    @Override
    public List<CommunityBoard> getAllCommunityBoards() {
        return communityBoardRepository.findAll();
    }

    // 특정 커뮤니티 게시판 (id로) 조회
    public CommunityBoard getCommunityBoardById(Long boardId) {
        return communityBoardRepository.findById(boardId).orElse(null);
    }

    // 특정 커뮤니티 게시판 (name으로) 조회
    public CommunityBoard getCommunityBoardByName(String name) {
        return communityBoardRepository.findByName(name);
    }


}
