package com.example.libary_manager.repositorys;

import com.example.libary_manager.configs.MysqlConnect;
import com.example.libary_manager.models.Libary;
import com.example.libary_manager.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final MysqlConnect mysqlConnect = new MysqlConnect();

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();

        Connection connection = mysqlConnect.getConnection();
        String query = "select * from account u where u.username = ? and u.password = ?";

        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setUsername(username);
            user.setPassword(password);
            users.add(user);
        }
        connection.close();

        return users.get(0);
    }

    public List<Libary> getLibaryByUserId(int idUser) throws SQLException, ClassNotFoundException {
        List<Libary> libaries = new ArrayList<Libary>();

        Connection connection = mysqlConnect.getConnection();
        String query = "select * from account_libary_room u where u.account_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idUser);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Libary libary = new Libary();
            libary.setId(resultSet.getInt("id"));
            libaries.add(libary);
        }

        preparedStatement.close();

        connection.close();

        return libaries;
    }
}