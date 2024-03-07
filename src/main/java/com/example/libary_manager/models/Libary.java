package com.example.libary_manager.models;

public class Libary {
    private int id;
    private String name;
    private int managerId;
    private int borrowerId;
    private int numberBook;

    public Libary(){

    }
    public Libary(int id, String name, int managerId, int borrowerId, int numberBook){
        this.id = id;
        this.name = name;
        this.borrowerId = borrowerId;
        this.managerId = managerId;
        this.numberBook = numberBook;

    }
    public int getId() {
        return id;
    }

    public int getBorrowerId() {
        return borrowerId;
    }

    public int getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

    public int getNumberBook() {
        return numberBook;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowerId(int borrowerId) {
        this.borrowerId = borrowerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setNumberBook(int numberBook) {
        this.numberBook = numberBook;
    }
}
