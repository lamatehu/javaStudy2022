package com.hou.AlgorithmBox;

/**
 * 二分查找
 *
 * @author hou
 * @date 2023/03/10 01:35
 */
public class BinarySearch {
    public static void main(String[] args) {
        //二分查找必须是一个有序数组
        int[] arr = {1,4,6,8,13,67,98,100};
        int i = binarySearch(arr, 1);
        System.out.println(i);
    }

    /**
     * 二分查找
     *
     * @return int 返回数组下标，如果没有返回-1
     */
    public static int binarySearch(int[] arr,int num){
        int center;
        int value;
        int left = 0;
        int right = arr.length-1;

        while (left<=right) {
            center=(left+right)/2;
            value = arr[center];
            if (value == num) return center;
            if (value > num) {
                right = center-1;
            }
            if (value < num) {
                left = center+1;
            }
        }
        return -1;
    }
}
