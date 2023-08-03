package com.elgineer.hackertonelgineer.repository;

import com.elgineer.hackertonelgineer.dto.CommunityBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityBoardRepository extends JpaRepository<CommunityBoard, Long> {
    CommunityBoard findByName(String name);
}
