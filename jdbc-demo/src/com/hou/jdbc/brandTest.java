package com.hou.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.hou.jdbc.pojo.brand;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class brandTest {

    //获取连接
    public Connection getConnect() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("D:\\javastudy\\jdbc-demo\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        return connection;
    }
    //获取连接后的操作
    public List<brand> selectSome(Connection connection) throws SQLException {
        PreparedStatement ppSt = connection.prepareStatement("select * from tb_brand");
        ResultSet resultSet = ppSt.executeQuery();
        brand brand = null;
        List<brand> brands = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String brand_name = resultSet.getString("brand_name");
            String company_name = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            brand = new brand();
            brand.setId(id);
            brand.setBrand_name(brand_name);
            brand.setCompany_name(company_name);
            brand.setDescription(description);
            brand.setOrdered(ordered);
            brand.setStatus(status);
//            放入集合
            brands.add(brand);
        }
        resultSet.close();
        ppSt.close();
        connection.close();
        return brands;
    }
    public void addSome(Connection connection) throws SQLException {
        String brandName = "112";
        String companyName = "公1";
        Integer ordered = 2;
        String description = "333";
        Integer status = 1;

        PreparedStatement ppst = connection.prepareStatement("insert into tb_brand(brand_name,company_name,ordered,description,status) values(?,?,?,?,?);");
        ppst.setString(1,brandName);
        ppst.setString(2,companyName);
        ppst.setInt(3,ordered);
        ppst.setString(4,description);
        ppst.setInt(5,status);

        int i = ppst.executeUpdate();
        if (i>0){
            System.out.println("添加成功");
        }
        ppst.close();
        connection.close();

    }
    public void updateSome(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE tb_brand \n" +
                "SET brand_name = ?,\n" +
                "company_name = ?,\n" +
                "ordered = ?,\n" +
                "description = ?,\n" +
                "`status` = ?\n" +
                "WHERE id = ?");
        preparedStatement.setString(1,"香飘飘");
        preparedStatement.setString(2,"香飘飘公司");
        preparedStatement.setInt(3,1000);
        preparedStatement.setString(4,"一个好喝的奶茶");
        preparedStatement.setInt(5,0);
        preparedStatement.setInt(6,4);

        int i = preparedStatement.executeUpdate();
        if (i>0) System.out.println("添加成功");
        printResult(selectSome(connection));
    }
    public void deletSome(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from tb_brand where id = ?");
        preparedStatement.setInt(1,3);
        int i = preparedStatement.executeUpdate();
        if (i>0) System.out.println("删除成功");
        printResult(selectSome(connection));
        preparedStatement.close();
        connection.close();

    }
    public void printResult(List<brand> brands){
        for (brand brand : brands) {
            System.out.println(brand.getBrand_name() +"\t"
            + brand.getId() + "\t" +
              brand.getCompany_name() + "\t"+
              brand.getDescription() +   "\t"+
              brand.getOrdered() + "\t"+
              brand.getStatus()

            );
        }
    }
    @Test
    public void test1() throws Exception {
        //printResult(selectSome(getConnect()));
        //addSome(getConnect());
        //updateSome(getConnect());
        deletSome(getConnect());
    }
}
