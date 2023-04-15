package com.hou.stack;

/**
 * 使用链表进行栈的模拟（测试）
 *
 * @author hou
 * @date 2023/01/06 10:05
 */
public class LinkedStackDemo {
    public static void main(String[] args) {
//        测试类
        LinkedStack linkedStack = new LinkedStack(5);
        //略



    }
}

/**
 * 节点 构造节点
 *
 * @author hou
 * @date 2023/01/07 12:34
 */
class Node{
    public int no;
    public String name;
    private Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;

    }

    public Node getNext() {
        return next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}


/**
 * 链表模拟堆栈
 * head 节点作为头节点
 * @author hou
 * @date 2023/01/06 10:08
 */
class LinkedStack{
    public int maxSize;
    Node head = new Node(0,"");

    /**
     * 传入maxsize 的构造函数
     * 设定栈的大小
     *
     * @param maxSize 最大尺寸
     */
    public LinkedStack(int maxSize) {
        this.maxSize = maxSize;
    }



    /**
     * 栈是否满了
     *
     * @return boolean
     */
    public boolean isFull(){
        Node temp = head;

        int sum = 1;
        while (temp.getNext() != null) {
            sum++;
            temp = temp.getNext();
        }
        System.out.println(maxSize + "  " + sum);
        if (maxSize < sum) return true;
        return false;
    }

    public boolean isEmpty(){
        if (head.getNext() == null){
            throw new RuntimeException("栈空");
        }
        return false;

    }

    public void push(Node node){
        if (isFull()){

            throw new RuntimeException("栈满了，无法添加");

        }else {
            Node temp = null;
            //            往栈顶添加数据
            temp =  head.getNext();
            head.setNext(node);
            node.setNext(temp);
        }


    }

    public void pop(){
        if (isEmpty()){
            System.out.println("无法出栈");
        }else {
            String aa = head.getNext().toString();
            System.out.printf("现在出栈的是\t %S",aa);
            head.setNext(head.getNext().getNext());
        }
    }

    public void showList(){
        int count = 0;
        Node temp = head;
        if (isEmpty()){
            System.out.println("栈中没有元素");
        }else {
            while (temp.getNext() != null){
                count++;
                String s = temp.getNext().toString();

                System.out.printf("[%d]\t%s\n",count,s);
                temp = temp.getNext();

            }
            System.out.println("目前栈中一共有\t"+ count);

        }
    }
}
