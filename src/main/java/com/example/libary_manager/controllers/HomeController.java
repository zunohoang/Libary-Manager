package com.example.libary_manager.controllers;

import com.example.libary_manager.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "home", value = "/home")
public class HomeController extends HttpServlet {


    @Override
    @SuppressWarnings("unchecked")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        List<User> users = null;
        if(session.getAttribute("users") != null){
            users = (List<User>) session.getAttribute("users");
            System.out.println("Đăng nhập thành công");
            System.out.println("Name: " + users.get(0).getName());
            request.getRequestDispatcher("index.jsp").forward(request,response);
        } else {
            System.out.println("Chuyển hương qua trang đặp nhập (Không có session)");
            response.sendRedirect("dang-nhap");
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

    }
    public void destroy() {
    }
}
