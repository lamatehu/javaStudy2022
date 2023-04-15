package com.hou.queue;

import java.util.Scanner;

public class CircleQueue {
    /**
     * @time 2023-1-1
     * 循环队列
     * 这解决了一个问题 就是利用数组创建的队列只能使用一次的问题
     * front指定的是 队列的开头
     * rare指定的是 队列末尾+1的位置
     * maxSize 指定的数组最大的容量
     * 队列最大可容纳的元素为maxSize-1
     * 队列目前的元素数量为 (rare+maxSize - front) % maxSize
     */
    private int maxSize; //队列容量
    private int front; //头标记
    private int rare; //尾标记
    private int[] arr; //队列

    public CircleQueue(int maxsize) {
        maxSize = maxsize;
//        front 和 rare 都从头开始
        front = 0;
        rare = 0;

        arr = new int[maxSize];
    }

    //    判断循环数组队列  front == rare
    public boolean isEmpty() {
        return front == rare;
    }

    //    判断循环数组队列是否满了            r 0 f 1
    public boolean isFull() {
        return (rare + maxSize - front) % maxSize == maxSize - 1;
    }

    public void addNum(int n) {
        if (isFull()) {
            throw new RuntimeException("队列满了");
        }
        arr[rare] = n;
        rare = (rare + 1 + maxSize) % maxSize;
    }

    public void delNum() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int res = arr[front];
        arr[front] = 0;
        System.out.printf("arr[%d] 值为 %d", front, res);
        front = (front + 1 + maxSize) % maxSize;
    }

    public int pickFront() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        System.out.printf("arr[%d] 值为 %d", front, arr[front]);
        return arr[front];
    }

    public void showqQueue() {
        int length = (rare + maxSize - front) % maxSize;
        System.out.printf("目前front为 %d \t 目前rare为 %d",front,rare);
        System.out.println("目前队列中的元素有" + length);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("目前数组情况");
        for (int i = front; i < length+front; i++) {

            System.out.printf("arr[%d] 值为 %d \n", i % maxSize, arr[i%maxSize]);
        }
    }
}

    class CircleQueueTest{
        public static void main(String[] args) {
//        先new一个队列
            CircleQueue circleQueue = new CircleQueue(4);
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
                        circleQueue.showqQueue();
                        break;
                    case 'a':
                        System.out.println("请输入您想添加的值");
                        int i = scanner.nextInt();
                        try {
                            circleQueue.addNum(i);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 'g':
                        try {
                            circleQueue.delNum();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 'p':
                        try {
                            circleQueue.pickFront();
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
