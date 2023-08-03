package com.elgineer.hackertonelgineer.repository;

import com.elgineer.hackertonelgineer.dto.CommunityBoardPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityBoardPostRepository extends JpaRepository<CommunityBoardPost, Long> {

}
