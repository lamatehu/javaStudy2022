package com.hou.queue;

import java.lang.annotation.Documented;
import java.util.Scanner;

public class ArrayQueue {
/**
 * @author hou
 * 这是一个用数组模拟队列的类
 * 队列的方法有
 * - 判断队列是否为空 isEmpty
 * - 判断队列是否满了 isFull
 * 这个队列有一个问题就是使用一次，想要多次使用。最好使用循环队列
 */
    private int maxSize; //队列容量
    private int front; //头标记
    private int rare; //尾标记
    private int[] arr; //队列

    public ArrayQueue(int maxsize){
        maxSize = maxsize;
        front = -1;
        rare = -1;
        arr = new int[maxSize];
    }

    public boolean isEmpty(){
        return front == rare;
    }

    public boolean isFull(){
        return rare == maxSize-1;
    }

    public void addNum(int n){
        if (isFull()){
            System.out.println("此时队列maxsize :"+ maxSize + "rare" + rare);
            throw new RuntimeException("队列已满");
        }
        rare++;
        arr[rare] = n;
    }
    public int deletNum(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
//        将队列中目前第一个取出，并将其赋值为0;
        front++;
        int res = arr[front];
        arr[front] = 0;
        System.out.printf("取出的数据为 arr[%d] = %d \n", front,res);
        return res;
    }

    public int pickFront(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        System.out.printf("头为:%d \t arr[%d] \n", arr[front+1],front+1);
        return arr[front+1];
    }
    public void showqQueue(){
        //队列是先进先出的，所以显示要先判断这个时候到哪里了
        for (int i : arr) {
            System.out.println(i);
        }
//        int rara1 = rare;
//        for(int i=front;i<rara1;i++){
//            System.out.printf(" arr[%d] = %d \n", i,arr[i]);
//        }
    }
}

class ArrayQueueTest{
    public static void main(String[] args) {
//        先new一个队列
        ArrayQueue arrayQueue = new ArrayQueue(4);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("查看队列 s");
            System.out.println("添加到队列 a");
            System.out.println("从队列中取出 g");
            System.out.println("查看元素头 p");
            System.out.println("退出 e");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    arrayQueue.showqQueue();
                    break;
                case 'a':
                    System.out.println("请输入您想添加的值");
                    int i = scanner.nextInt();
                    try {
                        arrayQueue.addNum(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        arrayQueue.deletNum();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        arrayQueue.pickFront();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case  'e':
                    loop = false;
                    System.out.println("退出");
                    break;

            }
        }


    }

}
