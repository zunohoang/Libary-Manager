package com.example.libary_manager.controllers;

import com.example.libary_manager.repositorys.UserRepository;
import com.example.libary_manager.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "dang-nhap", value = "/dang-nhap")
public class LoginController extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Người dùng truy cập trang đăng nhập");
        request.getRequestDispatcher("dang-nhap.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(" ");
        System.out.println("<-- Đăng Nhập -->");
        System.out.println("Tài khoản: " + username + " | Mật khẩu: " + password);
        User user = null;
        try {
            user = userRepository.getUserByUsernameAndPassword(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(user != null){
            System.out.println("Dang nhap thanh cong");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("chon-thu-vien");
        } else {
            request.getRequestDispatcher("dang-nhap.jsp").forward(request, response);
        }
    }
    public void destroy() {
    }
}
