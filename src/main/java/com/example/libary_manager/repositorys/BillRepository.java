package com.example.libary_manager.repositorys;

import com.example.libary_manager.configs.MysqlConnect;
import com.example.libary_manager.models.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {

    private final MysqlConnect mysqlConnect = new MysqlConnect();

    public List<Bill> selectBill(int idLibary, int tag) throws  SQLException, ClassNotFoundException{
        List<Bill> bills = new ArrayList<Bill>();

        Connection connection = mysqlConnect.getConnection();
        String query = "select * from bill where libary_id = ? order by id DESC LIMIT 5 OFFSET " + 5*(tag-1);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idLibary);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Bill bill = new Bill();
            bill.setId(resultSet.getInt("id"));
            bill.setTimeStart(resultSet.getDate("time_start"));
            bill.setTimeEnd(resultSet.getDate("time_end"));
            bill.setIdBook(resultSet.getInt("book_id"));
            bill.setNameBook(resultSet.getString("name_book"));
            bill.setIdBorrower(resultSet.getInt("brrower_id"));
            bill.setNameBorrower(resultSet.getString("name_borrower"));
            bill.setStatus(resultSet.getInt("status"));
            bills.add(bill);
        }

        preparedStatement.close();

        connection.close();

        return bills;

    }

    public boolean addBill(Bill bill) throws SQLException, ClassNotFoundException {

        Connection connection = mysqlConnect.getConnection();
        String query = "insert into bill (book_id, libary_id, brrower_id, manager_id, name_borrower, name_book, time_start, time_end, status) values (?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bill.getIdBook());
        preparedStatement.setInt(2, bill.getIdLibary());
        preparedStatement.setInt(3, bill.getIdBorrower());
        preparedStatement.setInt(4, 0);
        preparedStatement.setString(5, bill.getNameBorrower());
        preparedStatement.setString(6, bill.getNameBook());
        preparedStatement.setDate(7, bill.getTimeStart());
        preparedStatement.setDate(8, bill.getTimeEnd());
        preparedStatement.setInt(9, bill.getStatus());

        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        return rows > 0;
    }

    public Bill findBillById(int id) throws SQLException, ClassNotFoundException{
        Connection connection = mysqlConnect.getConnection();
        String query = "select * from bill where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Bill bill = new Bill();
            bill.setId(resultSet.getInt("id"));
            bill.setTimeStart(resultSet.getDate("time_start"));
            bill.setTimeEnd(resultSet.getDate("time_end"));
            bill.setIdBook(resultSet.getInt("book_id"));
            bill.setNameBook(resultSet.getString("name_book"));
            bill.setIdBorrower(resultSet.getInt("brrower_id"));
            bill.setNameBorrower(resultSet.getString("name_borrower"));
            bill.setStatus(resultSet.getInt("status"));

            preparedStatement.close();

            connection.close();

            return bill;
        }

        return null;
    }

    public void confirmBill(int id) throws SQLException, ClassNotFoundException{
        Connection connection = mysqlConnect.getConnection();
        String query = "update bill set status = 1 where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();
    }

    public void deleteBill(int id) throws SQLException, ClassNotFoundException{
        Connection connection = mysqlConnect.getConnection();
        String query = "delete from bill where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();
    }

}
