package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Borrower;
import com.example.libary_manager.models.Libary;
import com.example.libary_manager.repositorys.BorrowerRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "quan-ly-nguoi-muon", urlPatterns = {"/quan-ly-nguoi-muon"})
public class BorrowerController extends HttpServlet {
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int idLibary = ((Libary)session.getAttribute("libary")).getId();

        int tag = 1;
        if(req.getParameter("tag") != null){
            tag = Integer.parseInt(req.getParameter("tag"));
        }

        try {
            List<Borrower> borrowers = borrowerRepository.selectBorrower(idLibary, tag);
            req.setAttribute("borrowers", borrowers);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("quan-ly-nguoi-muon.jsp").forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idBorrower = Integer.parseInt(req.getParameter("id"));

        try {
            borrowerRepository.deleteBorrower(idBorrower);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String bornString = req.getParameter("born");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // Adjust the date format based on your input
        Date born = null;

        try {
            born = df.parse(bornString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        int number_book = Integer.parseInt(req.getParameter("number_book"));
        int number_completed = Integer.parseInt(req.getParameter("number_completed"));

        String number_phone = req.getParameter("number_phone");
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        int idLibary = ((Libary)session.getAttribute("libary")).getId();

        Borrower borrower = new Borrower(0, name, born, number_phone, email, number_book, number_completed, idLibary);
        System.out.println(borrower);

        try {
            if(borrowerRepository.addBorrower(borrower)){
                resp.sendRedirect("quan-ly-nguoi-muon");
            } else {
                req.getRequestDispatcher("pages-error-404.html").forward(req, resp);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
