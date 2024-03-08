package com.example.libary_manager.repositorys;

import com.example.libary_manager.configs.MysqlConnect;
import com.example.libary_manager.models.Book;
import com.example.libary_manager.models.User;
import com.example.libary_manager.services.CacheBookSevice;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private final MysqlConnect mysqlConnect = new MysqlConnect();

    private CacheBookSevice cacheBook = new CacheBookSevice();

    public boolean addBook(Book book) throws SQLException, ClassNotFoundException {
        cacheBook.addCache(book.getLibary_id(), book);

        Connection connection = mysqlConnect.getConnection();
        String query = "insert into books (name, discription, libary_id, number, number_now, author) values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getDiscription());
        preparedStatement.setInt(3, book.getLibary_id());
        preparedStatement.setInt(4, book.getNumber());
        preparedStatement.setInt(5, book.getNumber_now());
        preparedStatement.setString(6, book.getAuthor());

        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        return rows > 0;
    }

    public boolean deleteBook(int id) throws SQLException, ClassNotFoundException {
        Connection connection = mysqlConnect.getConnection();
        String query = "delete from books where id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        int rows = preparedStatement.executeUpdate();

        preparedStatement.close();

        connection.close();

        return rows > 0;
    }

    public List<Book> selectBook(int libaryId, int tag) throws SQLException, ClassNotFoundException {
        List<Book> books = new ArrayList<Book>();

        Connection connection = mysqlConnect.getConnection();
        String query = "SELECT * FROM books WHERE libary_id = ? ORDER BY id DESC LIMIT 10 OFFSET " + 10*(tag-1);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, libaryId);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String title = resultSet.getString("name");
            String author = resultSet.getString("author");
            int number = resultSet.getInt("number");
            int number_now = resultSet.getInt("number_now");
            String discription = "Chuc nang nay duoc cap nhat sau";
            Book book = new Book(id, title, discription, author, number, number_now, libaryId);
            books.add(book);
        }

        preparedStatement.close();

        connection.close();

        return books;
    }
}
