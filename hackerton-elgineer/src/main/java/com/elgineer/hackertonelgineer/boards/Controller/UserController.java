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


    @PostMapping("/register")
    public String register(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        userService.registerUser(user, encodedPassword);
        return "redirect:/login";
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

// 아래 코드는 postman 요청 보낼 때 사용했던 코드라 실제 페이지에서는 사용하지 않음.
//    @GetMapping("/info")
//    public User getCurrentUserInfo() {
//        User loggedInUser = (User) session.getAttribute("loggedInUser");
//        if (loggedInUser == null) {
//            throw new RuntimeException("로그인한 사용자가 없습니다.");
//        }
//        return userService.findByUsername(loggedInUser.getUsername());
//    }
//}
