package com.elgineer.hackertonelgineer.boards.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    // 로그인 상태를 확인하는 인터셉터
    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loggedInUser = session.getAttribute("loggedInUser");

        if (loggedInUser == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false; // 로그인하지 않은 사용자면 요청 처리를 중지
        }

        return true; // 로그인한 사용자면 요청 계속 진행
    }

}
