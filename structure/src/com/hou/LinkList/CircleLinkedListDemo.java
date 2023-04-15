package com.hou.LinkList;

/**
 * 循环链表演示
 *
 * @author hou
 * @date 2023/01/05 03:54
 */
public class CircleLinkedListDemo {
    public static void main(String[] args) {
        CircleLinkedList cl = new CircleLinkedList();
        cl.addBoy(25);
        cl.listBoy();
        cl.josephu(1,2);
    }

}

/**
 * 循环链表中子节点的构造函数
 *
 * @author hou
 * @date 2023/01/05 03:54
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}

class CircleLinkedList {
    //    首先先创建一个初始节点

    Boy first = new Boy(-1);

    /**
     * 添加子节点到环形链表
     *
     * @param numberOf 数量
     */
    public void addBoy(int numberOf) {
//        辅助指针
        Boy curBoy = new Boy(-1);
        for (int i = 1; i <= numberOf; i++) {
            Boy boy = new Boy(i);


//            第一个需要单独设计，让第一个节点的下一个指向它自己
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = boy;
            } else {
/*                step1: 将前一个的下一个连接到目前这个
                   step2: 将这一个的下一个连接到first
                   step3: 将辅助节点 移动到现在这个节点
 */
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = curBoy.getNext();
            }

        }
    }

    /**
     * 显示环形列表中所有子节点
     */
    public void listBoy() {
        if (first == null){
            System.out.println("目前链表为空");
        }
//        辅助遍历节点
        Boy curBoy = first;
        System.out.println("----所有节点----");
        while (true) {
            System.out.println(curBoy);
            if (curBoy.getNext() == first) break;
            curBoy = curBoy.getNext();
        }
    }


    /**
     * josephu 问题
     *
     * @param startNum 开始数的第几个
     * @param k       步长
     * @return int 随便设置的
     */
    public int josephu(int startNum,int k){
        System.out.println("约瑟夫问题");
        int sums = 0;
        Boy helper = first;
        while (true){
            sums ++;
            if (helper.getNext() == first) break;
            helper = helper.getNext();
        }
        System.out.printf( "现在一共有 %d 个节点\n helper指向 %S \n",sums,helper);
        listBoy();

        if(sums<=1 || first == null || sums<startNum){
            System.out.println("对不起，不算了");
            return 0;
        }
//        开始从哪里数
        for (int i=0;i<startNum-1;i++){
            helper = helper.getNext();
            first = first.getNext();
        }
        System.out.printf("目前 helper在 %S \n first在 %S \n",helper,first);
//        开始报数
        while (true){
            if (helper == first){
                System.out.println("已经是最后一个小朋友了" + first);
                break;
            }
            for (int j=0;j<k-1;j++){
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println("报数的小朋友是" + first);
//            开始移除这个小朋友
            first = first.getNext();
            helper.setNext(first);
        }
        return 0;
    }

}