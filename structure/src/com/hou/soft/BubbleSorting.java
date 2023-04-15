package com.hou.soft;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序
 * 冒泡排序就是比较相邻的两个元素的大小
 * 如果后面一个比前面一个大 则位置互换，之后循环遍历数组中元素数量-1次，就可以从大到校的排序完成
 *
 * @author hou
 * @date 2023/01/15 03:49
 */
public class BubbleSorting {
    int temp = 0;

    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
//        准备80000 个数据
        int[] arr888 = new int[80000];
        for (int i = 0; i<80000;i++){
            arr888[i] = (int)(Math.random()*10000);
        }

        BubbleSorting bubbleSorting = new BubbleSorting();
//        准备测试程序运行的时间
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd-hh:mm:ss");
        System.out.println(simpleDateFormat.format(date1));
        bubbleSorting.OptimizeBubble(arr888);
//        运行结束的时间
        Date date2 = new Date();
        System.out.println(simpleDateFormat.format(date2));
    }


    /**
     * 未优化版本的冒泡算法
     *
     * @param arr 需要排序的数组
     * @return {@link int[]}
     */
    public int[] simpleBubble(int[] arr) {
        int temp = 0; //定义一个缓存值
        /*
          循环次数定为 arr.length-1 是因为最极端的情况下需要排序 n-1次
          当把最大的元素 排序到最右边的时候，这个时候就不用管最后一个元素了，因为他是最大的元素
          所以这个时候就可以-1
          时间复杂度为 O(n^2)
         */
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            System.out.println("第" + (i + 1) + "次" + Arrays.toString(arr));
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 优化冒泡排序
     *
     * @param arr 需要排序的数组
     * @return {@link int[]}
     */
    public int[] OptimizeBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    说明变动过元素的值了
                    flag = true;
                }
            }
//          这个时候判断一下有没有变动过元素的位置 如果没有变动过直接结束循环,没有变动过则恢复循环开始时的状态
            if (flag == false) {
                break;
            } else {
                flag = false;
            }
        }
        return arr;

    }
}
