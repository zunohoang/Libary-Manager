package com.example.libary_manager.untils;

import com.example.libary_manager.models.Borrower;
import com.example.libary_manager.repositorys.BorrowerRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class test {

    private static final BorrowerRepository borrowerRepository = new BorrowerRepository();
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Borrower borrower = borrowerRepository.findBorrowerById(2);
        System.out.println(borrower);
    }
}
