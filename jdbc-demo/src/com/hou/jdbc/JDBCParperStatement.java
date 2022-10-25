package com.hou.jdbc;

import org.junit.Test;

import java.sql.*;

public class JDBCParperStatement {

    //包装statement 防止通过拼接字符串实现sql注入
    @Test
    public void parperState() throws SQLException, ClassNotFoundException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from job where id = ?");
        String name = "董事长";
        int id = 1;
        //preparedStatement.setString(1,name);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){

            String description = resultSet.getString("description");
            System.out.println("查到了" + description);
        }

        }
    }
