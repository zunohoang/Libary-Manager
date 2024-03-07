package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Libary;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "chon-thu-vien", value = "/chon-thu-vien")
public class LibaryController extends HttpServlet {
    private final UserRepository userRepository = new UserRepository();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Libary> libaries = new ArrayList<Libary>();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        try {
            libaries = userRepository.getLibaryByUserId(user.getId());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("libaries", libaries);
        req.getRequestDispatcher("chon-thu-vien.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idLibary = Integer.parseInt(req.getParameter("libaryId"));

        Libary libary = new Libary();
        libary.setId(idLibary);

        HttpSession session = req.getSession();
        session.setAttribute("libary", libary);

        resp.sendRedirect("home");
    }
    public void destroy() {
    }
}