package com.rajim.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author rajim on 3/19/18
 */
public class DbUtil {

    private static Connection connection =  null;

    public static Connection getConnection() {
        if(connection != null) {
            return connection;
        } else {
            try{
                Properties properties = new Properties();
                InputStream inputStream = DbUtil.class.getClassLoader()
                        .getResourceAsStream("/db.properties");
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                Class.forName(driver);
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");
                connection = DriverManager.getConnection(url, username, password);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
