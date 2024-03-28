package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Bill;
import com.example.libary_manager.models.Borrower;
import com.example.libary_manager.models.Libary;
import com.example.libary_manager.repositorys.BillRepository;
import com.example.libary_manager.repositorys.BorrowerRepository;
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
    private BorrowerRepository borrowerRepository = new BorrowerRepository();
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nameBook = req.getParameter("nameBook");
        String nameBorrower = req.getParameter("nameBorrower");
        int idBook = Integer.parseInt(req.getParameter("idBook"));
        int idBorrower = Integer.parseInt(req.getParameter("idBorrower"));

        HttpSession session = req.getSession();
        int idLibary = ((Libary)session.getAttribute("libary")).getId();

        LocalDateTime timeS = LocalDateTime.now();
        LocalDateTime timeE = timeS.plusDays(30);

        Date timeStart = Date.valueOf(timeS.toLocalDate());
        Date timeEnd = Date.valueOf(timeE.toLocalDate());

        Borrower borrower = null;

        try {
            borrower = borrowerRepository.findBorrowerById(idBorrower);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if(borrower != null){
                Bill bill = new Bill(0, nameBook, borrower.getName(), idBook, idBorrower, idLibary,timeStart, timeEnd, 0);
                try {
                    if(billRepository.addBill(bill)) {
                        resp.sendRedirect("tao-hoa-don");
                    } else {
                        resp.sendRedirect("pages-error-404.html");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                resp.sendRedirect("pages-error-404.html");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            billRepository.deleteBill(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
