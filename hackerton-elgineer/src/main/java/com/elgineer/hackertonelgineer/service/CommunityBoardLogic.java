package com.elgineer.hackertonelgineer.service;

import com.elgineer.hackertonelgineer.dto.CommunityBoard;

import java.util.List;

public interface CommunityBoardLogic {

    // 카테고리별로 게시판 생성하는 메서드
    void createFixedCommunityBoard();

    // 커뮤니티 게시판을 리스트로 생성하는 메서드
    List<CommunityBoard> getAllCommunityBoards();

    // 커뮤니티 보드를 id로 조회하는 메서드
    CommunityBoard getCommunityBoardById(Long boardId);

    // 커뮤니티 보드를 name으로 조회하는 메서드
    CommunityBoard getCommunityBoardByName(String name);

}
