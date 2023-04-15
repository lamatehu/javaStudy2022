package com.hou.Select;

import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 简单查找
 *
 * @author hou
 * @date 2023/01/24 07:08
 */
public class simpleSelect {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[30];
        int[] aa = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 8, 9, 10};
        //调用二分查找方法
        binarySearch(aa, 7, 0, aa.length - 1);
        //生成随机数组
        for (int i = 0; i < arr.length; i++) {
            int abs1 = Math.abs((int) (Math.random() * 100));
            arr[i] = abs1;
        }
        //调用简单查找方法
        ArrayList<Integer> integers = selectSimple(aa, 5);
        System.out.println(integers);
    }

    /**
     * 简单查找的方法
     *
     * @param arr 数组
     * @param num 要查询的数字
     * @return {@link ArrayList}<{@link Integer}>
     */
    public static ArrayList<Integer> selectSimple(int[] arr, int num) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                integers.add(i);
                integers.add(num);
                return integers;
            }
        }
        integers.add(-1);
        return integers;
    }

    /**
     * 二分查找
     * 该数组是有序的
     *
     * @param arr   需要查找的数组
     * @param num   查找的数字
     * @param left  左边界
     * @param right 右边界
     * @return {@link ArrayList}<{@link Integer}>
     */
    public static ArrayList<Integer> binarySearch(int[] arr, int num, int left, int right) {
        if (left > right) {
            System.out.println("没有找到");
            return null;
        }
        int middle = (left + right) / 2;
        if (arr[middle] > num) {
            return binarySearch(arr, num, left, middle);
        } else if (arr[middle] < num) {
            return binarySearch(arr, num, middle + 1, right);
        } else {
//            这部分是看一看前面和后面有没有相同的值，如果有的话也一并返回
            ArrayList<Integer> integers = new ArrayList<>();
            int temp = arr[middle];
            int l = 1;
            while (true) {
                if (temp != arr[middle - l] || middle - l < 0) {
                    break;
                }
                integers.add(middle - l);
                l--;
            }
            integers.add(middle);
            l = 1;
            while (true) {
                if (temp != arr[middle + l] || middle + l > arr.length - 1) {
                    break;
                }
                integers.add(middle + l);
                l++;
            }
            System.out.println(integers);
            return integers;
        }
    }
}