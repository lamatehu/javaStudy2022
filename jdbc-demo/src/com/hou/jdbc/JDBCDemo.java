package com.hou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 快速入门
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        int execute = statement.executeUpdate("UPDATE emp set bonus = 999 where id = 1001");

        System.out.println(execute);

        statement.close();
        connection.close();


    }
}
