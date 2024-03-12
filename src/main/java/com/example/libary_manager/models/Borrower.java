package com.example.libary_manager.models;

import java.util.Date;

public class Borrower {
    private int id;
    private String name;
    private Date born;
    private String numberPhone;
    private String email;
    private int numberBook;
    private int bookCompleted;
    private int idLibary;

    public int getIdLibary() {
        return idLibary;
    }

    public void setIdLibary(int idLibary) {
        this.idLibary = idLibary;
    }

    public Borrower() {
    }

    public Borrower(int id, String name, Date born, String numberPhone, String email, int numberBook, int bookCompleted, int idLibary) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.numberPhone = numberPhone;
        this.email = email;
        this.numberBook = numberBook;
        this.bookCompleted = bookCompleted;
        this.idLibary = idLibary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }

    public int getBookCompleted() {
        return bookCompleted;
    }

    public void setBookCompleted(int bookCompleted) {
        this.bookCompleted = bookCompleted;
    }
}
