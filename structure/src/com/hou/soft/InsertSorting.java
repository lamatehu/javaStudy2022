package com.hou.soft;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 插入排序
 *
 * @author hou
 * @date 2023/01/16 05:02
 */
public class InsertSorting {

    public static void main(String[] args) {
        int[] arr = {1, -1, -23, 88, 22};
        timeToShow(1);
        //插入算法是比较当前的元素能插到那个位置的算法
        InsertSorting(toGenerateAnArray(80000));
        timeToShow(2);
    }

    /**
     * 插入排序算法
     * <p>
     * 遍历数组的每一个元素，将当前元素插入到已排序好的数组中的适当位置
     *
     * @param arr 需要排序的数组
     * @return {@link int[]} 返回排序后的数组
     */
    public static int[] InsertSorting(int[] arr) {
        int InsertNum = 0;
        int InsertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            InsertNum = arr[i]; //当前元素
            InsertIndex = i - 1; //已排序好的数组中最后一个元素的下标
            while (InsertIndex >= 0 && InsertNum < arr[InsertIndex]) { //当前元素比已排序好的数组中的元素小
                arr[InsertIndex + 1] = arr[InsertIndex]; //将已排序好的数组中的元素往后移一位
                InsertIndex--;
            }
            if (InsertIndex + 1 != i) {
                arr[InsertIndex + 1] = InsertNum; //找到当前元素应该插入的位置并插入
            }

            //System.out.println(Arrays.toString(arr));
        }
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