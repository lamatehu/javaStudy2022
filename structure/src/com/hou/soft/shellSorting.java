package com.hou.soft;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 壳牌排序
 *
 * @author hou
 */
public class shellSorting {
    public static void main(String[] args) {
        int[] arr = {2, -4, 7, 22, -12, 55, 43, -98, 98, 22};
        //int[] ints = hillSorting(arr);
        insertHillSorting(arr);

        //System.out.println(Arrays.toString(ints));
    }

    /**
     * 交换法希尔排序
     *
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] exchangeHillSorting(int[] arr) {
        int temp = 0;
        // 首先确定步长，每次循环将步长除以 2，直到步长为1
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            // 从步长开始遍历整个数组
            for (int i = gap; i < arr.length; i++) {
                // 从当前位置往前遍历
                for (int j = i - gap; j >= 0; j = j - gap) {
                    temp = arr[j];
                    // 比较并交换元素
                    if (arr[j] > arr[j + gap]) {
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * 希尔排序(插入法)
     *
     * @param arr 需要排序的数组
     * @return 排序后的数组
     */
    public static int[] insertHillSorting(int[] arr) {
        int temp = 0;
        //第一步确定步长，每次循环将步长除以 2，直到步长为1
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
            //从中间开始遍历整个数组
            for (int i = gap; i < arr.length; i++) {
                //保存当前位置的值
                temp = arr[i];
                int j = i;
                //使用类似于插入排序的方法，比较和交换元素
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    /**
     * 时间显示
     *
     * @param i 第几次的时间
     */
    public static void timeToShow(int i) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh:mm:mm:ss SSS");
        String format = simpleDateFormat.format(date1);
        System.out.println("第" + i + " " + format);
    }

    /**
     * 生成一个测试算法的数组
     *
     * @param n 需要生成的数组长度
     * @return {@link int[]} 返回生成的数组
     */
    public static int[] toGenerateAnArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }

}
