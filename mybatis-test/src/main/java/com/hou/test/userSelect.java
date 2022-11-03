package com.hou.test;

import com.hou.mapper.userMapper;
import com.hou.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class userSelect {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        userMapper usermapper = sqlSession.getMapper(userMapper.class);
        List<user> user = usermapper.selectAll();
        System.out.println(user.toString());
    }
}
