package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.dto.User;

public interface UserService {
    void registerUser(User user);
    User findByUsername(String username);
    User loginUser(String username, String password);
    void logoutUser();
}
