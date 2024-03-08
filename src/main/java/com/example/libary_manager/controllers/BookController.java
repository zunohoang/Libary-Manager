package com.example.libary_manager.controllers;

import com.example.libary_manager.models.Book;
import com.example.libary_manager.models.Libary;
import com.example.libary_manager.repositorys.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "quan-ly-sach", urlPatterns = {"/quan-ly-sach"})
public class BookController extends HttpServlet {

    private final BookRepository bookRepository = new BookRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int tag = 1;
        if(req.getParameter("tag") != null){
            tag = Integer.parseInt(req.getParameter("tag"));
        }

        System.out.println(tag);
        HttpSession session = req.getSession();

        int libaryId = ((Libary)session.getAttribute("libary")).getId();

        List<Book> books = null;
        try {
            books = bookRepository.selectBook(libaryId, tag);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("books", books);
        req.getRequestDispatcher("quan-ly-sach.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("title");
        String author = req.getParameter("author");
        int number = Integer.parseInt(req.getParameter("number"));
        int numberNow = Integer.parseInt(req.getParameter("number"));
        String discription = "chu nang nay duoc cap nhat sao";

        HttpSession session = req.getSession();

        int libaryId = ((Libary)session.getAttribute("libary")).getId();

        Book book = new Book(1, name, discription, author, number, numberNow, libaryId);

        try {
            if(bookRepository.addBook(book)){
                resp.sendRedirect("quan-ly-sach");
            } else {
                req.getRequestDispatcher("pages-error-404.html").forward(req, resp);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Dodelete");
    }
}
