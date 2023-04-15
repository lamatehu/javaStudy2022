package com.hou.spaceArray;

import java.lang.reflect.Array;

public class spaceArray {
    public int[][] test22() {
       int[][] intArray = new int[8][8];
//       显示二维数组
       for (int i = 0;i< intArray.length;i++){
           for (int j=0;j<intArray[i].length;j++){
               System.out.print(intArray[i][j] + "\t");
           }
           System.out.println();
       }
//       给二维数组中赋初值 0 空 1 黑 2 白
        intArray[0][1] = 1;
        intArray[1][2] = 1;
        intArray[2][3] = 2;
        intArray[3][4] = 2;
        
//        通过上面的获取简单数组
//        1. 先获取有几个需要被记录的数组 遍历
        int count = 0;
        for (int[] i:
             intArray) {
            for (int j :
                 i) {
               if (j!= 0) count++;
            }
        }
        System.out.println(count +"你好");

//        设定这个数组 第一行为总揽
        int[][] intArray2 = new int[count+1][3];
        intArray2[0][0] = 8;
        intArray2[0][1] = 8;
        intArray2[0][2] = count;


        int sum = 0;
        for (int i = 0;i<intArray.length;i++){
            for (int j=0;j<intArray[i].length;j++){
                if (intArray[i][j] != 0){
                    sum++;

                    intArray2[sum][0] = i;
                    intArray2[sum][1] = j;
                    intArray2[sum][2] = intArray[i][j];

                }
            }
        }

//        打印以下看看
    System.out.println("疏");
        for (int[] ints : intArray2) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }


// 利用上面的数据再次创建这个二维数组
        int[][] intArray3 = new int[intArray2[0][0]][intArray2[0][1]];
        for (int i=1; i<=intArray2[0][2];i++){
            intArray3[intArray2[i][0]][intArray2[i][1]] = intArray2[i][2];
        }

//   显示第三个数组
        for (int i = 0;i< intArray3.length;i++){
            for (int j=0;j<intArray3[i].length;j++){
                System.out.print(intArray3[i][j] + "\t");
            }
            System.out.println();
        }
        return intArray2;
    }
}
