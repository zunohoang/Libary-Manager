package com.example.libary_manager.controllers;

import com.example.libary_manager.repositorys.BillRepository;
import com.example.libary_manager.repositorys.BorrowerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "tra-sach", urlPatterns = {"/tra-sach"})
public class BillBackController extends HttpServlet {
    private BillRepository billRepository = new BillRepository();
    private BorrowerRepository borrowerRepository = new BorrowerRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("tra-sach.jsp").forward(req, resp);
    }
}
