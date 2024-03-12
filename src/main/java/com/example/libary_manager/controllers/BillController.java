package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Bill;
import com.example.libary_manager.models.Libary;
import com.example.libary_manager.repositorys.BillRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@WebServlet(name = "tao-hoa-don", urlPatterns = {"/tao-hoa-don"})
public class BillController extends HttpServlet {

    private BillRepository billRepository = new BillRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tag = 1;
        if(req.getParameter("tag") != null){
            tag = Integer.parseInt(req.getParameter("tag"));
        }

        HttpSession session = req.getSession();
        int idLibary = ((Libary) session.getAttribute("libary")).getId();

        try {
            List<Bill> bills = billRepository.selectBill(idLibary, tag);
            req.setAttribute("bills", bills);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("tao-hoa-don.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        String nameBook = req.getParameter("nameBook");
        String nameBorrower = req.getParameter("nameBorrower");
        int idBook = Integer.parseInt(req.getParameter("idBook"));
        int idBorrower = Integer.parseInt(req.getParameter("idBorrower"));

        HttpSession session = req.getSession();
        int idLibary = ((Libary)session.getAttribute("libary")).getId();

        LocalDateTime timeS = LocalDateTime.now();
        LocalDateTime timeE = timeS.plusDays(30);

        Date timeStart = java.sql.Date.valueOf(timeS.toLocalDate());
        Date timeEnd = java.sql.Date.valueOf(timeE.toLocalDate());

        Bill bill = new Bill(0, nameBook, nameBorrower, idBook, idBorrower, idLibary, timeStart, timeEnd);

        try {
            if(billRepository.addBill(bill)){
                resp.sendRedirect("tao-hoa-don");
            } else {
                req.getRequestDispatcher("tao-hoa-don").forward(req,resp);
            }
        } catch (SQLException | ClassNotFoundException | IOException | ServletException e) {
            throw new RuntimeException(e);
        }

    }
}
