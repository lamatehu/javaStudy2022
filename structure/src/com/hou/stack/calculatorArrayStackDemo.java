package com.hou.stack;

/**
 * 计算器演示类
 * 中缀表达式法
 * 只能计算个位数的加减乘除
 * <p>
 * 1.遇到数字直接入数栈
 * 2.遇到符号 要判断
 * .1 如果符号的优先级<= 栈中上一个符号的优先级 则需要先和栈顶的运算符运算 否则直接入栈
 * .2 从数栈拿出两个数 和栈顶的符号运算，把结果放回数栈，之后把新的符号加入到符号栈
 * 3.读取完后即开始从左至右计算
 * .1 从数栈中拿出两个数 再从符号栈中拿出一个数，进行计算，结果放回数栈中
 * .2 当数栈中只有一个数时，即为结果 判断条件为 符号栈中没有符号 == null
 *
 * @author hou
 * @date 2023/01/07 03:04
 */
public abstract class calculatorArrayStackDemo {
    public static void main(String[] args) {
        ArrayStackCalculator numberStack = new ArrayStackCalculator(10);
        ArrayStackCalculator operatorStack = new ArrayStackCalculator(10);
        //    计算式
        String formula = "70+24*69-4";
        //    索引
        int index = 0;
        int num1;
        int num2;
        int operator;
        String keepNum = "";

        while (true) {
            char ch = formula.substring(index, index + 1).charAt(0);
            if (operatorStack.operatorPrecedence(ch) > -1) {
//                此时可以判定这个字符为 运算符
                if (operatorStack.isEmpty()) {
//                    如果此时栈中为空，直接入栈
                    operatorStack.push(ch);
                } else {
//                    此时栈中不空，就要判断优先级
                    if (operatorStack.orderOfOperations(ch, (char) operatorStack.peek())) {
//                        判断为 true 则需要计算

                        num1 = numberStack.pop();
                        num2 = numberStack.pop();
                        operator = operatorStack.pop();
                        int res = operatorStack.toCalculate(num1, num2, operator);
//                        计算结果入数栈
                        numberStack.push(res);
                        operatorStack.push(ch);
                    } else {
                        operatorStack.push(ch);

                    }
                }
            } else {
//                如果是数字的情况
               /* 直接入栈的话只能实现个位数的运算
                要实现多位数，就要判断下一个是否为运算符
               */
                if (formula.length()-1 == index){
                    numberStack.push(Integer.parseInt(keepNum+ch));
                }else {


                    keepNum = keepNum + ch;
//                        大于-1的话就是运算符
                    char nextChar = formula.substring(index + 1, index + 2).charAt(0);
                    System.out.println(nextChar + "\t nextChar");
                    if (operatorStack.operatorPrecedence(nextChar) > -1) {
                        int i = Integer.parseInt(keepNum);
                        numberStack.push(i);
//                            push 后 把 keepNum 清空
                        keepNum = "";
                    }
                }
            }
            index++;
            if (formula.length() < index + 1) {
                break;
            }
        }
        System.out.println("看一下数组");
        numberStack.showStack();
        operatorStack.showStack();
        while (!operatorStack.isEmpty()) {
//            如果数栈中 只有一个元素，则就是结果
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            operator = operatorStack.pop();
            int res = operatorStack.toCalculate(num1, num2, operator);
            numberStack.push(res);
        }
        System.out.printf("%s \t 结果为 %d\n", formula, numberStack.peek());
    }


}


/**
 * 计算器的数组堆栈
 * 添加了几个方法
 *
 * @author hou
 * @date 2023/01/06 02:22
 */
class ArrayStackCalculator {
    public int maxsize;
    public int top = -1;
    int[] stack;

    public ArrayStackCalculator(int maxsize) {
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

    /**
     * 查看栈顶的第一个元素
     *
     * @return int
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 是否需要进行运算的操作
     *
     * @param operator1 operator1 新来的操作符
     * @param operator2 operator2 堆栈中首个操作符
     * @return boolean 如果为 true 需要运算 false 直接入栈
     */
    public boolean orderOfOperations(char operator1, char operator2) {
//        如果当前操作符的优先级 小于或等于 栈中操作符
        if (operatorPrecedence(operator1) <= operatorPrecedence(operator2)) {
            return true;
        }
        return false;
    }

    /**
     * 运算符优先级
     * 如果是 * or / 返回 1
     * 如果是 + or - 返回0
     * 如果都不是 就是数字 返回-1
     *
     * @param operator 操作符
     * @return int
     */
    public int operatorPrecedence(char operator) {
        if (operator == '*' || operator == '/') return 1;
        if (operator == '+' || operator == '-') return 0;

        return -1;
    }

    /**
     * 计算
     *
     * @param num1     num1
     * @param num2     num2
     * @param operator 操作符
     * @return int
     */
    public int toCalculate(int num1, int num2, int operator) {
        int res = 0;
        char operator1 = (char) operator;
        switch (operator1) {
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                System.out.println("计算部分出错");
                System.out.printf("%d %s %d 结果为 %d", num1, operator1, num2, res);
                break;
        }
        return res;
    }


}
