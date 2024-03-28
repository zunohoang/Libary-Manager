package com.example.libary_manager.models;

import java.util.Date;

public class Bill {
    private int id;
    private String nameBook;
    private String nameBorrower;
    private int idBook;
    private int idBorrower;
    private int idLibary;

    private Date timeStart;
    private Date timeEnd;

    private int status;

    public Bill(){}
    public Bill(int id, String nameBook, String nameBorrower, int idBook,
                int idBorrower,int idLibary, Date timeStart, Date timeEnd, int status){
        this.id = id;
        this.nameBook = nameBook;
        this.nameBorrower = nameBorrower;
        this.idBook = idBook;
        this.idBorrower = idBorrower;
        this.idLibary = idLibary;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public java.sql.Date getTimeEnd() {
        return (java.sql.Date) timeEnd;
    }

    public java.sql.Date getTimeStart() {
        return (java.sql.Date) timeStart;
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

    public void setIdLibary(int idLibary) {
        this.idLibary = idLibary;
    }

    public int getIdLibary() {
        return idLibary;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
