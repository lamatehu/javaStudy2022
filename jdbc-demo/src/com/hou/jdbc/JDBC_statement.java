package com.hou.jdbc;

import com.hou.jdbc.pojo.job;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC_statement {
    /*
    这是数据库查询并且打印
     */
    @Test
    public void test_dml() throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from emp");

        while (resultSet.next()){
            //通过列的编号来获得数据，当然也可以通过列名来获得数据
            String date = resultSet.getString(1);
            String date1 = resultSet.getString(2);
            String date2= resultSet.getString(3);
            String date3 = resultSet.getString(4);
            String date4 = resultSet.getString(5);
            String date5 = resultSet.getString(6);
            String date6 = resultSet.getString(7);
            String date7 = resultSet.getString(8);

            System.out.println(date + '\t' +date1 + '\t'+date2 + '\t'+date3 + '\t'+date4 + '\t'+date5 + '\t'+date6 + '\t'+date7);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    /*
    这是一个获取数据库数据后，传递到list列表
     */
    @Test
    public void test_dmltest() throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from job");
        List<job> jobList = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String jname = resultSet.getString("jname");
            String description = resultSet.getString("description");
            System.out.println(jname);
            job job = new job(id,jname,description);
            jobList.add(job);
        }
        System.out.println(jobList.toString());
    }
}
