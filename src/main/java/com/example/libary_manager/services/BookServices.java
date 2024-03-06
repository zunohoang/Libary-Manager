package com.example.libary_manager.services;

import com.example.libary_manager.models.Book;

public class BookServices {
    public boolean addBook(Book book) {

        String queryAddBook = "INSERT INTO books (name, discription, libary_id, number, number_now, author)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";

        return true;
    }
}
