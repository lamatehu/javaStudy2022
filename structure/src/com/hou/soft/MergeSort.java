package com.hou.soft;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 归并排序
 *
 * @author hou
 * @date 2023/01/18 03:38
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,6,1,3,7,2};

        int[] ints = toGenerateAnArray(8000000);
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序的merge方法
     * @param arr 待排序数组
     * @param left 数组左边界
     * @param mid 数组中点
     * @param right 数组右边界
     * @param temp 临时数组
     *
     * 该方法的作用是合并两个有序数组,将两个有序数组合并成一个有序数组
     * 具体实现是:
     * 1. 从左边界和中点开始遍历,比较两边数组中对应位置的数字,将小的放入临时数组
     * 2. 如果左边或右边的数组已经遍历完,将剩下的部分放入临时数组
     * 3. 最后将临时数组中的数据放回原数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int l = left;
        int j = mid+1;
        int t = 0;

        //第一步先对两边的值进行比较 小的放到temp中
        while (l<=mid && j <=right){
            if (arr[l] >= arr[j]){
                temp[t] = arr[j];
                t++;
                j++;
            }else{
                temp[t] = arr[l];
                t++;
                l++;
            }
        }

        //第二步，如果出现一边已经遍历完另一边没有遍历的情况
        while (l<=mid){
            temp[t] = arr[l];
            l++;
            t++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        //第三步,最后把这个temp中的数组放回到 arr
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

    /**
     * 归并排序主方法
     * @param arr 待排序数组
     * @param left 数组左边界
     * @param right 数组右边界
     * @param temp 临时数组
     *
     * 该方法采用递归方式,先把数组不断分成左右两半,直到每一半只有一个元素为止
     * 然后再把两个有序的数组合并成一个有序的数组
     */
    public static void sort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);
            sort(arr,mid+1,right,temp);

            merge(arr,left,mid,right,temp);
        }
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
        System.out.println(i+"  "+format);
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
