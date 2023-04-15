package com.hou.queue;

import java.util.Scanner;

/**
 * 练习队列
 *
 * @author hou
 * @date 2023/02/27 17:00
 */
public class testQueue {
    public int maxSize;
    public int rare = 0;
    public int front = 0;
    private int[] queen;

    public testQueue(int maxSize) {
        maxSize = maxSize+1;
        this.maxSize = maxSize;
        this.queen = new int[maxSize];

    }

    /**
     * 判断队列是否满了
     * 判断 rare
     * @return boolean
     */
    public boolean isFull(){
        return (rare+1)% maxSize == front;
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     */
    public boolean isEmpty(){
        if (rare == front) return true;
        else return false;
    }

    public void addQueen(int num){
        if (isFull()){
            System.out.println("不好意思已经满了，无法添加");
            return;
        }
        rare = rare % maxSize;
        System.out.println(queen[rare]);
        queen[rare] = num;

        System.out.printf("添加成功,queen[%d]=%d \n",rare,queen[rare]);
        rare++;
    }

    /**
     * 出队列 先进先出，后进后出
     */
    public void delQueen(){
        if (isEmpty()){
            System.out.println("不好意思，队列为空");
            return;
        }

        System.out.printf("queen[%d] = %d",front,queen[front]);
        queen[front] = 0;
        front = (front + 1) % maxSize;
    }

    public void showList(){
        for (int i=0;i< queen.length;i++){
            System.out.printf("queen[%d]=%d \n",i,queen[i]);
        }
    }


}

class test{
    public static void main(String[] args) {
        System.out.println("hhaa");
        testQueue testQueue = new testQueue(4);
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag){
            System.out.println("a 添加，d 删除，s 展示 e 退出");
            String next = sc.next();
            switch (next){
                case "a":
                    System.out.println("请输入你想添加的");
                    int i = sc.nextInt();
                    testQueue.addQueen(i);
                    break;
                case "d":
                    testQueue.delQueen();
                    break;
                case "s":
                    testQueue.showList();
                    break;
                case "e":
                    flag = false;
                    break;
            }

        }
        sc.close();

    }
}