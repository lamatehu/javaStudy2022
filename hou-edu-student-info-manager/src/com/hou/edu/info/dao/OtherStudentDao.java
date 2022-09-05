package com.hou.edu.info.dao;

import com.hou.edu.info.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao implements BaseStudentgDao{
    private static ArrayList<Student> stus = new ArrayList<>();

    static {
        Student stu1 = new Student("heima001","11","22","199805");
        stus.add(stu1);
    }
    public boolean addStudent(Student stu) {
        stus.add(stu);
        return true;
    }

    public Student[] findAllStudent() {
        Student students[] = new Student[stus.size()];
        for (int i=0;i<stus.size();i++){
            students[i] = stus.get(i);
        }
        return students;

    }

    public void deleteStudentByid(String id) {
        int index = searchStudentByid(id);
        //给该索引赋值null
        stus.remove(index);
    }

    //通过id查找索引
    public int searchStudentByid(String id){
        int index = -1;
        for (int i = 0;i< stus.size();i++){
            Student stu = stus.get(i);
            if (stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void fixStudent(String id, Student newstu) {
        int index = searchStudentByid(id);
        stus.set(index,newstu);

    }
}
