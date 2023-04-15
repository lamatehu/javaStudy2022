package com.hou.recursion;

import java.util.Arrays;

/**
 * 八个皇后问题
 *
 * @author hou
 * @date 2023/01/14 04:39
 */
public class queenEight {
// 设定最大有8个皇后
    int MaxQueen = 8;
    int[] board = new int[8]; // 棋盘
    int count = 0; //初始化问题解决次数
    public static void main(String[] args) {
        queenEight queenEight = new queenEight();
        queenEight.setQueen(0);
    }

    /**
     * 设置女王
     *
     * @param n n 放置到第几个皇后了
     * @return boolean
     */
    public void setQueen(int n){
        if (n == MaxQueen){
            //说明现在已经放到第八个皇后了
            printQueen();
            return;
        }
            for (int i=0;i<8;i++){
//          从当前行处开始遍历
                board[n] = i;
//                如果判断可以放置就设置递归让放下一个皇后,如果不可以就会回到这一层递归
                if (judge(n)){
                    setQueen(n+1);
                }
            }
    }

    /**
     * 判断当前皇后是否符合规则
     *
     * 这里使用一个关于斜率的算法
     * @param n 传递过来的是当前皇后的 列的位置
     */
    public boolean judge(int n){
//
        for (int i=0;i<n;i++){
            if (board[i] == board[n] || Math.abs(n-i) == Math.abs(board[n] - board[i])){
/*      第一个条件是判断 前几个皇后有没有值和现在这个皇后相等的 相等说明他们在一列上 不符合
        第二个条件是判断 Math.abs(n-i) == Math.abs(board[n] - board[i]) 当前皇后的位置是否在同一斜线上。
        这个判断斜率的原理
        判断是依靠斜率的公式 k = (y2-y1) / (x2-x1)  如果 x1-x2 = y1-y2 那么这两个点就在同一斜线上。
        通过判断行和列差值是否相等，就可以判断斜线上有没有皇后

 */
                return false;
            }
        }
        return true;
    }

    /**
     * 打印皇后问题的一个解法
     */
    public void printQueen(){
        count++;
        System.out.println(count + " " + Arrays.toString(board));
    }
}
