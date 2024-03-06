package com.example.libary_manager.models;

public class Book {
    private int id;
    private String name;
    private String discription;
    private int libary_id;
    private int number;
    private int number_now;
    private String author;

    public Book(int id, String name, String discription, String author, int number, int number_now, int libary_id){
        this.id = id;
        this.name = name;
        this.author = author;
        this.discription = discription;
        this.number = number;
        this.number_now = number_now;
        this.libary_id = libary_id;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLibary_id() {
        return libary_id;
    }

    public int getNumber() {
        return number;
    }

    public int getNumber_now() {
        return number_now;
    }

    public String getAuthor() {
        return author;
    }

    public String getDiscription() {
        return discription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setLibary_id(int libary_id) {
        this.libary_id = libary_id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumber_now(int number_now) {
        this.number_now = number_now;
    }
}