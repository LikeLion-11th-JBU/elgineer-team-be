package com.elgineer.hackertonelgineer.boards.Repository;


import com.elgineer.hackertonelgineer.boards.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
}
