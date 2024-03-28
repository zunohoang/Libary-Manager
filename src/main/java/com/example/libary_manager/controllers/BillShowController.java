package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Bill;
import com.example.libary_manager.repositorys.BillRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "hoa-don", urlPatterns = {"/hoa-don"})
public class BillShowController extends HttpServlet {

    private BillRepository billRepository = new BillRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Bill bill = billRepository.findBillById(id);
            System.out.println("Trang thai: " + bill.getStatus());
            req.setAttribute("bill", bill);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
 
        req.getRequestDispatcher("hoa-don.jsp").forward(req, resp);
    }
}
