package com.example.libary_manager.models;

import java.util.Date;

public class Bill {
    private int id;
    private String nameBook;
    private String nameBorrower;
    private int idBook;
    private int idBorrower;
    private int idLibary;

    private Date timeCreate;
    private Date timeLimit;

    public int getId() {
        return id;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getIdBorrower() {
        return idBorrower;
    }

    public String getNameBook() {
        return nameBook;
    }

    public String getNameBorrower() {
        return nameBorrower;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setIdBorrower(int idBorrower) {
        this.idBorrower = idBorrower;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setNameBorrower(String nameBorrower) {
        this.nameBorrower = nameBorrower;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setIdLibary(int idLibary) {
        this.idLibary = idLibary;
    }

    public int getIdLibary() {
        return idLibary;
    }
}
