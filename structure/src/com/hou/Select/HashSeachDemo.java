package com.hou.Select;

import java.util.Scanner;

/**
 *
 * 这段代码是一个散列表的演示程序。它包含三个类：HashSeachDemo、Emp和EmpLinkList。
 *
 * HashSeachDemo类中的main方法是程序的入口，
 * 它创建了一个HashArrays对象，并使用Scanner读取用户输入，根据用户输入执行相应操作。
 *
 * @author hou
 * @date 2023/01/25 05:40
 */
public class HashSeachDemo {
    public static void main(String[] args) {
        HashArrays hashArrays = new HashArrays(7);
        Scanner sc = new Scanner(System.in);
        outerloop:
        while (true){
            System.out.println("add 添加");
            System.out.println("list 显示");
            System.out.println("exit 退出");
            System.out.println("del 删除");
            ;
            switch (sc.next()){
                case "add":
                    System.out.print("id");
                    int id = sc.nextInt();
                    System.out.print("name");
                    String name = sc.next();
                    hashArrays.add(id,name);
                    break;

                case "list":
                    hashArrays.list();
                    break;
                case "exit":
                    sc.close();
                    break outerloop;
                case "find":
                    System.out.println("你要查找的");
                    id = sc.nextInt();
                    hashArrays.find(id);
                    break;
                case "del":
                    System.out.println("你要删除哪一个");
                    int i = sc.nextInt();
                    hashArrays.del(i);
            }
        }
    }
}

/**
 * Emp类是链表中的元素类型，
 * 包含了id和name两个属性，以及一个next属性表示指向下一个元素。
 *
 * @author hou
 * @date 2023/01/27 11:16
 */
class Emp {
    private int id;
    private String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 *EmpLinkList类是链表类，
 * 包含了添加、删除、查找和显示链表元素的方法。
 * @author hou
 * @date 2023/01/27 11:16
 */
class EmpLinkList{
    private Emp head;

    /**
     * 添加
     *
     * @param emp 电磁脉冲
     */
    public int add(Emp emp){
        if (head == null){
            head = emp;
        }else {
            Emp curNext =head;
            while (curNext.next !=null) curNext = curNext.next;
            curNext.next = emp;
        }
        return 0;
    }

    /**
     * 删除
     * 用id删除
     *
     * @param id id
     */
    public int del(int id){
        Emp curNext = head;
//        先找到
        if (head.getId() == id){
            head = head.next;
        }
        while (curNext.next != null) {
            if (curNext.next.getId() == id) {
                if (curNext.next.next != null) {
                    curNext.next = curNext.next.next;
                } else {
                    curNext.next = null;
                }
                return 0;

            }
            curNext = curNext.next;
        }
        return -1;
    }

    /**
     * 列表
     */
    public void list(){
        if (head == null) System.out.println("链表为空");
        Emp curNext = head;

        int no = 1;
        while (curNext !=null){
            System.out.printf("=>no %d 的内容为id= %d \t name= %s \t",no,curNext.getId(),curNext.getName());
            curNext = curNext.next;
        }
        System.out.println();
    }
    public Emp find(int id){

        if (head ==null){
            System.out.println("哈哈哈");
            return null;
        }
        Emp curNext = head;
        while (curNext != null){
            System.out.println(curNext.getId());
            if (curNext.getId() == id){
                System.out.println("找到了");
                return curNext;
            }
            if (curNext.next ==null) break;
            curNext = curNext.next;
        }
        return null;
    }

}

/**
 *HashArrays类是散列表类，
 * 使用多条链表组成，每个链表对应一个散列值。该类中包含了添加、删除、查找和显示散列表元素的方法。
 *
 * @author hou
 * @date 2023/01/27 11:16
 */
class HashArrays{
    private EmpLinkList[] empLinkListArray;
    private int size;

    public HashArrays(int size){
        this.size =  size;
        empLinkListArray = new EmpLinkList[size];
        for (int i=0;i<size;i++){
            empLinkListArray[i] = new EmpLinkList();
        }
    }

    public void add(int id,String name){
       int n = id%size;
        Emp emp = new Emp(id, name);
        int add = empLinkListArray[n].add(emp);
        if (add == 1){
            System.out.println("添加成功");
        }
    }

    public void list(){
        for (int i=0;i<size;i++){
            empLinkListArray[i].list();
        }
    }
    public void del(int id){
        int n = id%size;
        int del = empLinkListArray[n].del(id);
        if (del == -1) System.out.println("删除失败");
        else System.out.println("删除成功");
    }

    public void find(int id){
        int n = id%size;
        Emp emp = empLinkListArray[n].find(id);
        if (emp != null){
            System.out.println(emp.getId() +"\t" + emp.getName());
        }else {
            System.out.println("没找到");
        }
    }



}



