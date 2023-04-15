package com.hou.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 波兰后缀表达式 栈 计算器
 * 传入 一个波兰后缀表达式就可以计算
 *
 * @author hou
 * @date 2023/01/08 05:29
 */
public class PolishNotationStackCalDemo {
    public static void main(String[] args) {
        String s = "1 88 22 / 22 +";

        List<String> strings = convertAString(s);
        int i = postfixExpressionToCalculate(strings);
        System.out.println("结果:" + i);
        String ss = "1+(88/22+22)";
        List<String> list = convertingStringToList(ss);
        System.out.println(list);
        ArrayList<String> strings1 = infixExpressfixExpression(list);
        System.out.println(strings1);


    }

    /**
     * 后缀表达式来计算
     *
     * @param list 传入分割好的String 类型的列表
     * @return int 返回结果
     */
    public static int postfixExpressionToCalculate(List<String> list) {
        Stack<String> stack = new Stack<>();
        int res = 0;
        for (String s : list) {
            if (s.matches("\\d+")) {
                stack.push(s);
            } else {
//                否则就pop出两个数进行计算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if (s.equals("+")) {
                    res = num1 + num2;
                } else if (s.equals("-")) {
                    res = num1 - num2;
                } else if (s.equals("*")) {
                    res = num1 * num2;
                } else if (s.equals("/")) {
                    res = num1 / num2;
                }
                //计算完成后 就把res push进栈 因为res 是int 所以
                stack.push("" + res);
            }
        }
//        循环结束后 栈中只有一个元素 这个元素就是结果
        if (stack.size() == 1) {
            res = Integer.parseInt(stack.pop());
            System.out.println("计算完成");
        }
        return res;
    }


    /**
     * 转换后缀表达式字符串 为 后缀表达式列表
     *
     * @param s 后缀表达式
     * @return {@link List}<{@link String}>
     */
    public static List<String> convertAString(String s) {
        String[] s1 = s.split(" ");
        List<String> st = new ArrayList<>();
        for (int i = 0; i < s1.length; i++) {
            st.add(s1[i]);
        }
        return st;
    }

    /**
     * 将字符串转换为列表
     *
     * @param s 传入不带空格的字符串
     * @return {@link List}<{@link String}> 返回转换好的中缀表达式的列表
     */
    public static List<String> convertingStringToList(String s) {
        List<String> list = new ArrayList<String>();
        char c;
        int index = 0; // 字符串索引

        String str = "";
        do {

            c = s.charAt(index);
            if (c < '0' || c > '9') {

//                此时是符号
                list.add(c + "");
                index++;
            } else {
                str = "";
                int ssk = 0;
                System.out.println(index);
                while (s.charAt(index) >= '0' && s.charAt(index) <= '9') {

                    str = str + s.charAt(index);
                    index++;
                    ssk++;
                }
                ssk = 0;
                list.add(str);
                System.out.println(index + "\t" + str);
            }

        } while (index < s.length());
        return list;
    }


    /**
     * 中缀表达式转换为后缀表达式
     *
     * 1. 先创建两个栈 s1 和 数组 s2
     * 开始循环遍历数组
     * 2. 遇到数字 直接入 数栈
     * 3. 遇到括号
     * 3.1 遇到 "(" 直接入 s1 符号栈
     * 3.2 遇到 ")" 的情况 从s1中pop出元素到s2 直到遇到"(" 丢弃括号
     *
     * 4. 遇到符号
     * 4.1 如果符号栈为空 或者 栈顶为"("则直接入栈
     * 4.2 否则 栈顶的优先级高 把s1的pop出来 add 到s2上
     * 4.3 否则 判断符号的优先级 栈顶的优先级低 则直接入s1栈
     *
     * 5. 全部遍历完后把s1中剩余的都 pop出来 加入到 s2 中，返回s2
     *
     * @param list 列表
     * @return {@link ArrayList}<{@link String}>
     */
    public static ArrayList<String> infixExpressfixExpression(List<String> list) {
        //创建两个栈
        System.out.println("你好啊啊啊啊");
        Stack<String> s1 = new Stack<>();
        ArrayList<String> s2 = new ArrayList<>();
        for (String s : list) {
            if (s.matches("\\d+")) {
                System.out.println(s);
                s2.add(s);
            } else if (s.equals("(")) {
                s1.push(s);
            } else if (s.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                if (s1.size() == 0 || s1.peek().equals("(")) {
                    s1.push(s);
                } else
                    while (s1.size() !=0 && comparePriority.toCompare(s) <= comparePriority.toCompare(s1.peek())) {
                        s2.add(s1.pop());
                    }
                    s1.push(s);
                }
            }
        for (String s3 : s1) {
            s2.add(s3);
            System.out.println("haha");
        }
        return s2;
    }
}

        /**
         * 比较算数运算符优先级
         *
         * @author hou
         * @date 2023/01/10 09:13
         */
        class comparePriority {
            private static int ADD = 1;
            private static int SUB = 1;
            private static int MUL = 2;
            private static int DIV = 2;


            /**
             * 比较运算符的优先级
             *
             * @param operator 操作符
             * @return int 返回 0 1 or 2  先乘除后加减
             */
            public static int toCompare(String operator) {
                int res = 0;
                switch (operator) {
                    case "+":
                        res = ADD;
                        break;
                    case "-":
                        res = SUB;
                        break;
                    case "*":
                        res = MUL;
                        break;
                    case "/":
                        res = DIV;
                        break;


                }
                return res;
            }
        }



