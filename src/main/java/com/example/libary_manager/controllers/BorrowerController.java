package com.example.libary_manager.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "quan-ly-nguoi-muon", urlPatterns = {"/quan-ly-nguoi-muon"})
public class BorrowerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("quan-ly-nguoi-muon.jsp").forward(req, resp);
    }
}
