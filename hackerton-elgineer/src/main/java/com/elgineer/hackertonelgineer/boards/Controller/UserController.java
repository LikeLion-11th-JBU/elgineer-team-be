package com.elgineer.hackertonelgineer.boards.Controller;

import com.elgineer.hackertonelgineer.boards.dto.User;
import com.elgineer.hackertonelgineer.boards.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    public BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userService.registerUser(user, encodedPassword);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user) {
        User loggedInUser = userService.loginUser(user.getUsername(), user.getPassword());
        if (loggedInUser != null) {
            session.setAttribute("loggedInUser", loggedInUser);
            // 로그인 성공 시 세션에 "loggedInUser" 속성 설정
            return "redirect:/board";
        }
        return "login"; // 로그인에 실패하면 다시 로그인 페이지로
    }

    @PostMapping("/logout")
    public String logout() {
        userService.logoutUser();
        return "redirect:/board";
    }


}
