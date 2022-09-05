package com.hou.edu.info.factory;

import com.hou.edu.info.dao.BaseStudentgDao;
import com.hou.edu.info.dao.OtherStudentDao;
import com.hou.edu.info.dao.StudentDao;

//工厂学生配置类
public class StudentDaoFactory {
    public static BaseStudentgDao getStudentDao(){
        return new OtherStudentDao();
    }
}
