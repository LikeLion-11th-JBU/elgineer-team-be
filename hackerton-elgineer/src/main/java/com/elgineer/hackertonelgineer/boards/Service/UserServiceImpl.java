package com.elgineer.hackertonelgineer.boards.Service;

import com.elgineer.hackertonelgineer.boards.Repository.UserRepository;
import com.elgineer.hackertonelgineer.boards.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    
    @Override
    public User loginUser(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("loggedInUser", user);
            // 로그인 했을 때 세션에 유저 정보 저장
            return user;
        }
        return null;
    }

    @Override
    public User getLoggedInUser() {
        return (User) session.getAttribute("loggedInUser");
    }

    @Override
    public void logoutUser() {
        session.removeAttribute("loggedInUser");
    }
}
