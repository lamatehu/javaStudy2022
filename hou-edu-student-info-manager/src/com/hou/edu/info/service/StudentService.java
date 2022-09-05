package com.hou.edu.info.service;

import com.hou.edu.info.dao.BaseStudentgDao;
import com.hou.edu.info.dao.OtherStudentDao;
import com.hou.edu.info.dao.StudentDao;
import com.hou.edu.info.domain.Student;
import com.hou.edu.info.factory.StudentDaoFactory;

public class StudentService {
    BaseStudentgDao studentgDao = StudentDaoFactory.getStudentDao();
    OtherStudentDao studentDao = new OtherStudentDao();
    //StudentDao studentDao = new StudentDao();
    public boolean addStudent(Student stu) {

        boolean flag = studentDao.addStudent(stu);
        return flag;
    }
    //判断id是否存在的方法 ，返回ture 是存在 false 是不存在
    public boolean isExist(String id) {
        Student[] stus = studentDao.findAllStudent();
        boolean exist = false;

        for (int i=0;i<stus.length;i++) {
            Student student = stus[i];
            System.out.println(id +" "+exist+"  "+i + "  ");
            if (student != null){
                System.out.println(student.getId() );

            }
            if (student != null && student.getId().equals(id)) {
                exist = true;

                break;
            }
        }
        return exist;
    }

    public void deleteStudentByid(String id) {
        studentDao.deleteStudentByid(id);
    }

    public Student[] findAllStudent() {
        Student[] stus = studentDao.findAllStudent();
        return stus;
    }

    public void fixStudent(String id, Student newstu) {
        studentDao.fixStudent(id,newstu);
    }
}
