package com.hou.jdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Properties;

public class JDBCDruid {


    @Test
    public void DruidTest() throws Exception {
//        先导入jar包
//        创建配置文件 druid.poperties
//        用properties来loadproperties文件
        System.out.println(System.getProperty("user.dir")); //获取目前的路径，之后需要读文件的时候把后面没有的填到相对路径中
        Properties pr = new Properties();
        pr.load(new FileInputStream("druid.properties"));
        System.out.println(pr);
//        用druid来获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pr);
//          获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
