package com.hou.recursion;

public class recursionTest {
    public static void main(String[] args) {
        printRecursion(8);
        System.out.println("----------------");
        System.out.println(factorialProblem(8));
    }
//    打印问题
    public static void printRecursion(int n){

        if (n>2){
            printRecursion(n-1);
        }
        System.out.println(n);


    }
//    阶乘问题
    public static int factorialProblem(int n){
        if(n == 1){
            return 1;
        }else {
            return factorialProblem(n-1)*n;
        }
    }
}
