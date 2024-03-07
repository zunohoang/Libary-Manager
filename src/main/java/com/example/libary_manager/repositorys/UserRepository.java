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

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Lấy kết nối đến cơ sở dữ liệu
            connection = mysqlConnect.getConnection();

            // Chuẩn bị câu lệnh SQL với LIMIT 1
            String query = "SELECT id, name FROM account WHERE username = ? AND password = ? LIMIT 1";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            // Thực thi truy vấn
            resultSet = preparedStatement.executeQuery();

            // Nếu có kết quả, tạo đối tượng người dùng
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(username);
                user.setPassword(password);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // Đóng tất cả tài nguyên
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return user;
    }

    public List<Libary> getLibaryByUserId(int idUser) throws SQLException, ClassNotFoundException {
        List<Libary> libaries = new ArrayList<Libary>();

        Connection connection = mysqlConnect.getConnection();
        String query = "select * from account_libary_room u, libary_room v  where u.account_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, idUser);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Libary libary = new Libary();
            libary.setId(resultSet.getInt("v.id"));
            libary.setName(resultSet.getString("name"));
            libaries.add(libary);
        }

        preparedStatement.close();

        connection.close();

        return libaries;
    }
}