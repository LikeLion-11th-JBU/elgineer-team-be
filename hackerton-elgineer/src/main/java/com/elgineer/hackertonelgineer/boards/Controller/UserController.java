package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.dto.User;
import com.elgineer.hackertonelgineer.boards.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "회원가입 완료";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            // 로그인 성공 시 세션에 "loggedInUser" 속성 설정
            return "로그인 성공";
        }
        return "로그인 실패";
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "로그아웃 성공";
    }

    @GetMapping("/info")
    public User getCurrentUserInfo() {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            throw new RuntimeException("로그인한 사용자가 없습니다.");
        }
        return userService.findByUsername(loggedInUser.getUsername());
    }
}
