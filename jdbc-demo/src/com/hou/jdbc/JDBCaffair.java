package com.hou.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCaffair {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        //开启事务
        try {
            connection.setAutoCommit(false);
            Statement statement1 = connection.createStatement();
            statement1.executeUpdate("UPDATE emp set bonus = 999 where id = 1001");
            Statement statement2 = connection.createStatement();
            statement1.executeUpdate("update emp set bonus = 975 where id = 1002");
            //提交事务
            connection.commit();
            //关闭连接
            statement1.close();
            statement2.close();
        } catch (Exception e) {
            //如果出错回滚事务
            connection.rollback();
            System.out.println("回滚事务");
            e.printStackTrace();

        }

        connection.close();


    }
}
