package com.rajim.dao;

/**
 * @author rajim on 3/19/18
 */
import com.rajim.modal.User;
import com.rajim.util.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection connection;

    public UserDao(){
        connection = DbUtil.getConnection();
    }

    public void addUser(User user) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `testServlet`.`users` (\n" +
                    "  `first_name`,\n" +
                    "  `last_name`,\n" +
                    "  `dob`,\n" +
                    "  `email`\n" +
                    ") \n" +
                    "VALUES\n" +
                    "  (\n" +
                    "    '"+user.getFirst_name()+"',\n" +
                    "    '"+user.getLast_name()+"',\n" +
                    "    '"+user.getDob()+"',\n" +
                    "    '"+user.getEmail()+"'\n" +
                    "  ) ");
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT \n" +
                    "  `id`,\n" +
                    "  `first_name`,\n" +
                    "  `last_name`,\n" +
                    "  `dob`,\n" +
                    "  `email` \n" +
                    "FROM\n" +
                    "  `test_servlet`.`users`");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirst_name(resultSet.getString("first_name"));
                user.setLast_name(resultSet.getString("last_name"));
                user.setDob(resultSet.getString("dob"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}

