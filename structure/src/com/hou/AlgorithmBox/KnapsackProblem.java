package com.hou.AlgorithmBox;

import org.junit.Test;

/**
 * 背包问题
 *
 * @author hou
 * @date 2023/03/13 01:35
 */
public class KnapsackProblem {
    @Test
    public void test1() {
        // 先确定二维数组的大小
        //w: 物品重量数组
        //v: 物品价值数组
        //m: 背包容量
        int[] w = {1, 4, 3};
        int[] v = {1500, 3000, 2000};
        int m = 4;
        //创建一个二维数组 这个数组的大小 高和宽都要+1
        //行是背包容量，列是商品价值
        // 这里为什么要+1，因为第一行和第一列都要置0
        int[][] bp = new int[w.length + 1][m + 1]; //列，行
        int[][] path = new int[w.length + 1][m + 1];

        // 对第一行和第一列分别置0
        for (int i = 0; i < m + 1; i++) {
            bp[0][i] = 0;
        }
        for (int i = 0; i < w.length; i++) {
            bp[i][0] = 0;
        }

        //动态规划 从1开始是因为第一行第一列代表的是第零行的情况
        for (int i = 1; i < bp.length; i++) {
            for (int j = 1; j < bp[0].length; j++) {
                //如果现在物品的重量小于背包的重量
                if (j < w[i - 1]) {
                    //直接把上一行的重量复制粘贴到本行上
                    bp[i][j] = bp[i - 1][j];
                } else {
                    // 判断究竟是不选这个物品的价值大，还是选这个物品的价值大
                    //后面这个是 这个物品的价值+如果选了这个物品后剩余空间能放物品的最大价值
                    //bp[i][j] = Math.max(bp[i-1][j],v[i-1]+bp[i-1][j-w[i-1]]);
                    if (bp[i - 1][j] < v[i - 1] + bp[i - 1][j - w[i - 1]]) {
                        bp[i][j] = v[i - 1] + bp[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        bp[i][j] = bp[i - 1][j];
                    }
                }
            }
        }

        //打印bp数组
        for (int i = 0; i < bp.length; i++) {
            for (int j = 0; j < bp[0].length; j++) {
                System.out.print(bp[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("=====path=====");
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                System.out.print(path[i][j] + "\t");
            }
            System.out.println();
        }

        //现在只能获得表，但是怎么最优放包还是不知道，这个时候反向遍历获取最优策略
        int i = path.length - 1;
        int j = path[0].length - 1;
        //逆序遍历
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                //i 是列，表示物品的价值
                System.out.println("现在拿出来的是" + i);
                // 因为现在放进去的这个需要从重量中减去
                j = j - w[i - 1];
            }
            i--;

        }
    }
}



