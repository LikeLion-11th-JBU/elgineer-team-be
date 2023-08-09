package com.elgineer.hackertonelgineer.boards.Repository;

import com.elgineer.hackertonelgineer.boards.dto.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {
    Optional<CommunityBoard> findByName(String name);
    // 나중에 보드와 관련된 추가 기능이 필요하면 여기에 작성할 것
}
