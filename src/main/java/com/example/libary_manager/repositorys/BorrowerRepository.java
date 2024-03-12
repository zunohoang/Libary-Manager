package com.example.libary_manager.repositorys;

import com.example.libary_manager.configs.MysqlConnect;
import com.example.libary_manager.models.Borrower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowerRepository {
    private final MysqlConnect mysqlConnect = new MysqlConnect();

    public List<Borrower> selectBorrower(int idLibary, int tag) throws SQLException, ClassNotFoundException {
        List<Borrower> borrowers = new ArrayList<Borrower>();

        Connection connection = mysqlConnect.getConnection();
        String query = "select * from borrower where borrower.id_libary = ? ORDER BY id DESC LIMIT 10 OFFSET " + 10*(tag-1);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idLibary);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Borrower borrower = new Borrower();
            borrower.setId(resultSet.getInt("id") + 24000);
            borrower.setName(resultSet.getString("name"));
            borrower.setBorn(resultSet.getDate("born"));
            borrower.setNumberPhone(resultSet.getString("number_phone"));
            borrower.setEmail(resultSet.getString("email"));
            borrower.setNumberBook(resultSet.getInt("number_book"));
            borrower.setBookCompleted(resultSet.getInt("number_book_datra"));
            borrower.setIdLibary(resultSet.getInt("id_libary"));

            borrowers.add(borrower);
        }

        preparedStatement.close();

        connection.close();

        return borrowers;
    }

    public void deleteBorrower(int idBorrower) throws SQLException, ClassNotFoundException{

        Connection connection = mysqlConnect.getConnection();
        String query = "delete from borrower where borrower.id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idBorrower - 24000);

        int row = preparedStatement.executeUpdate();
        System.out.println(row);

        preparedStatement.close();

        connection.close();
    }

    public boolean addBorrower(Borrower borrower) throws SQLException, ClassNotFoundException{

        Connection connection = mysqlConnect.getConnection();
        String query = "insert into borrower (name, number_phone, discription, email, number_book, number_book_datra, born, id_libary) values (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, borrower.getName());
        preparedStatement.setString(2, borrower.getNumberPhone());
        preparedStatement.setString(3, "Chuc nang nay cap nhat sau");
        preparedStatement.setString(4, borrower.getEmail());
        preparedStatement.setInt(5, borrower.getNumberBook());
        preparedStatement.setInt(6, borrower.getBookCompleted());
        Date untilDate = borrower.getBorn();
        java.sql.Date sqlTime = new java.sql.Date(untilDate.getTime());
        preparedStatement.setDate(7, sqlTime);
        preparedStatement.setInt(8, borrower.getIdLibary());

        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        return rows > 0;

    }
}
