package com.hou.soft;

import java.util.Arrays;

/**
 * 快速排序 中间值作为比较对象
 *
 * @author hou
 * @date 2023/01/17 06:21
 */
public class QuickSorting {
    public static void main(String[] args) {
        int[] arr = {0,-1,9,0,18,-2,-3};
        quickss(arr, 0, arr.length - 1);




    }


    /**
     * 快速排序 中间值法
     *
     * @param arr   数组
     * @param left  左
     * @param right 正确
     */
    public static void quicksort(int[] arr, int left, int right) {
        // 确定中间的值
        int priov = (left+right)/2;
        int r = right;
        int l = left;
        int temp = 0;
        //为什么要l小于r呢,因为在循环中 r是从右到左遍历，而l是从左到右遍历
        while (l<r){
            //假如 l的值小于 中间指针的值 则看看下一个
            while (arr[l] < arr[priov]){
                l++;
            }
            while (arr[r] > arr[priov]){
                r--;
            }
//            说明数组越位了
            if (l>=r){
                break;
            }

//            两边值交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == arr[priov]){
                r--;
            }
            if (arr[r] == arr[priov]){
                l++;
            }

            if (l == r){
                l++;
                r--;
            }
//            递归
            if (left<r){
                quicksort(arr,left,r);
            }
            if (right>l){
                quicksort(arr,l,right);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // 23:18
    public static void quickss(int[] arr,int left,int right){
        int r = right;
        int l = left;
        int privot = (r+l)/2;
        int temp = 0;

        while (l<r){
            while (arr[l] < arr[privot]){
                l++;
            }
            while (arr[r] > arr[privot]){
                r--;
            }

            if (l >= r) break;
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (privot == l) r--;
            if (privot == r) l++;

            if (l == r){ l++; r--;}

            //递归
            if (l<right){
                quickss(arr,left,r);
            }
            if (r>left){
                quickss(arr,l,right);
            }


        }
        System.out.println(Arrays.toString(arr));
    }
}
