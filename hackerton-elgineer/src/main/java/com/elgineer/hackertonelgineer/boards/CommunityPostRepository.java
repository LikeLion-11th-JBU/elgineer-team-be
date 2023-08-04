package com.elgineer.hackertonelgineer.boards;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityPostRepository extends JpaRepository<CommunityPost, Long> {
    // 나중에 게시글과 관련된 추가 기능이 필요하면 여기에 선언가능
}
