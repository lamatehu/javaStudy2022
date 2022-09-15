package com.hou.xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class demo1XMLGet {
    public static void main(String[] args) throws DocumentException {
        //利用xml读取数据
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("logback/src/com/hou/xml/Students.xml");
        Element rootElement = read.getRootElement();
        List<Element> studentsElement = rootElement.elements("Student");

        //创建学生数组
        ArrayList<Student> StudentList = new ArrayList<>();
        for(Element element : studentsElement){
            Attribute id = element.attribute("id");
            //获取学生id
            String idData = id.getStringValue();
            //获取名字年龄信息
            Element name = element.element("name");
            String nameData = name.getText();
            Element age = element.element("age");
            String ageData = age.getText();
            Element message = element.element("message");
            String messageData = message.getText();
            System.out.println(nameData+ " "+idData.toString() + " " + ageData +" "+ messageData);
            // 信息获取完毕 创建对象后添加到数组中
            Student student1 = new Student(Integer.parseInt(idData),Integer.parseInt(ageData),nameData,messageData);
            StudentList.add(student1);
        }
        //最后输出两个对象
        System.out.println(StudentList.toString());
    }
}
