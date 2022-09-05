package com.hou.edu.info.dao;

import com.hou.edu.info.domain.Student;

public interface  BaseStudentgDao {

    public abstract boolean addStudent(Student stu);

    public abstract Student[] findAllStudent();

    public abstract void deleteStudentByid(String id);

    //通过id查找索引
    public abstract int searchStudentByid(String id);

    public abstract void fixStudent(String id, Student newstu);
}
