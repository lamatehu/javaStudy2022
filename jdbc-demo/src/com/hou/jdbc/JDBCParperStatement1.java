package com.hou.jdbc;

import java.math.BigDecimal;
import java.sql.*;

public class JDBCParperStatement1 {

    /*
    防止sql注入需要使用parperStatement方法，Statement方法容易造成sql注入的问题，因为
    使用的是拼接字符串
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册服务
        Class.forName("com.mysql.jdbc.Driver");
        // JDBC连接
        String user = "root";
        String password = "a11816811";
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        Connection connection = DriverManager.getConnection(url, user, password);
//        查询id和salary是否都符合，如果不符合则登录失败，符合则成功
        PreparedStatement preparedStatement = connection.prepareStatement("select id,salary from emp where id = ? and salary = ?");
        preparedStatement.setInt(1,1001);
        preparedStatement.setBigDecimal(2,new BigDecimal(8000));

        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);
//        拿到结果开始判断，是否有数据，没有则失败
        if (resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
}
