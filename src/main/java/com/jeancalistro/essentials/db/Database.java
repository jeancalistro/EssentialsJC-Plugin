package com.jeancalistro.essentials.db;
import java.sql.*;

public class Database {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/minecraft";
        String user = "root";
        String password = "password";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to Database!");
        return connection;
    }

    public void initializeDatabase(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS Warp (id int NOT NULL AUTO_INCREMENT PRIMARY KEY, name varchar(255) NOT NULL UNIQUE, world varchar(255) NOT NULL, x double NOT NULL, y double NOT NULL, z double NOT NULL)";
        statement.execute(sql);

        statement.close();
    }
}
