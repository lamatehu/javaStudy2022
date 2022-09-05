package com.hou.edu.info.dao;

import com.hou.edu.info.domain.Student;

import java.lang.reflect.Array;

public class StudentDao implements BaseStudentgDao {
    private static Student[] stus =  new Student[5];
    public boolean addStudent(Student stu) {

        int index = -1;
        for (int i=0;i<= stus.length;i++){
            if (stus[i] == null){
                index = i;
                break;
            }

        }
        if (index == -1) {
            return false;
        }else {
            stus[index] = stu;
            return true;
        }

    }

    public Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentByid(String id) {
        int index = searchStudentByid(id);
        //给该索引赋值null
        stus[index] = null;
    }

    //通过id查找索引
    public int searchStudentByid(String id){
        int index = -1;
        for (int i = 0;i< stus.length;i++){
            Student stu = stus[i];
            if (stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void fixStudent(String id, Student newstu) {
        int index = searchStudentByid(id);
        stus[index] = newstu;
    }
}
