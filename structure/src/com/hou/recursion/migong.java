package com.hou.recursion;

/**
 * 迷宫问题
 *
 * @author hou
 * @date 2023/01/13 05:56
 */
public class migong {
    /**
     * 迷宫类型实现类
     *
     * @param args arg游戏
     */
    public static void main(String[] args) {
//       先创建一个8*7的地图
        int[][] map = new int[8][7];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0 || j == 6) {
                    map[i][j] = 1;

                } else if (i == 0 || i == 7) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
//        设置墙壁
        map[3][1] = 1;
        map[3][2] = 1;
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        searchPath(map, 1, 1);
//        显示结果
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    /**
     * 搜索路径
     * 设定 0 为 未走过的点
     * 1 为墙壁
     * 2 为走过可以走的点
     * 3 走过不能走的点
     * @param map 地图
     * @param i   列
     * @param j   行
     */
    public static boolean searchPath(int[][] map, int i, int j) {
//        先来判断是否走到了最后一个点
        if (map[6][5] == 2) {
            System.out.println("找到了");
            return true;
        }else {

//        没有的话如果现在这个点是0 就给他变为2
        if (map[i][j] == 0) {

            map[i][j] = 2;
//            向下走
            if (searchPath(map,i+1,j)) {
                return true;
//                向右走
            } else if (searchPath(map,i,j+1)) {
                return true;
//                向左走
            } else if (searchPath(map,i,j-1)) {
                return true;
//                向上走
            } else if (searchPath(map,i-1,j)) {
                return true;
            }else {
//                如果上下左右都走不通就设定为不可走通的点
                map[i][j] = 3;
                return false;
            }

        }else {
//            如果不是0是1，2，3的话说明没找到 返回false
            return false;
        }
        }
    }
}
