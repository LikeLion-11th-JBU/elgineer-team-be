package com.elgineer.hackertonelgineer.boards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {
    CommunityBoard findByName(String name);
    // 나중에 보드와 관련된 추가 기능이 필요하면 여기에 작성할 것
}
