package com.hou.stack;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

/**
 * 使用数组来模拟栈(实现类)
 *
 * @author hou
 * @date 2023/01/06 02:21
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack ass = new ArrayStack(3);
        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            System.out.println("a:\t 入栈\n" +
                    "p:\t 出栈\n" +
                    "s:\t 展示\n" +
                    "e:\t 退出");
            String next = sc.next();
            switch (next) {
                case "a": //入栈
                    System.out.println("入栈值");
                    int i = sc.nextInt();
                    try {

                        ass.push(i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "p": //出栈
                    try {
                        int value = ass.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }


                    break;
                case "s":
                    try {
                        ass.showStack();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "e":
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }

}

    /**
     * 数组堆栈 方法构造
     *
     * @author hou
     * @date 2023/01/06 02:22
     */
    class ArrayStack {
        public int maxsize;
        public int top = -1;
        int[] stack;

        public ArrayStack(int maxsize) {
            this.maxsize = maxsize;
            stack = new int[maxsize];
        }

        public boolean isFull() {
            if (maxsize - 1 == top) {
                System.out.println("栈满");
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            if (top == -1) {
                System.out.println("栈空");
                return true;
            }
            return false;
        }

        /**
         * 入栈操作
         *
         * @param insertNum 插入num
         */
        public void push(int insertNum) {
            if (isFull()) throw new RuntimeException("不能入栈");
            top++;
            stack[top] = insertNum;

        }

        /**
         * 出栈操作
         *
         * @return int 返回这个值
         */
        public int pop() {
            if (isEmpty()) throw new RuntimeException("没有元素了,无法出栈");
            int value = stack[top];
            System.out.printf("stack[%d]\t%d\t出栈\n", top, stack[top]);
            top--;
            return value;
        }

        /**
         * 显示栈中元素
         */
        public void showStack() {
            if (isEmpty()) throw new RuntimeException("没有元素了,无法展示");
            for (int i = top; i > -1; i--) {
                System.out.printf("stack[%d]\t%d\n", i, stack[i]);
            }
        }
    }


