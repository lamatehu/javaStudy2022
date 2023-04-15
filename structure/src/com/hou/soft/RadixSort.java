package com.hou.soft;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 基数排序
 *
 * @author hou
 * @date 2023/01/18 06:59
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        RadixSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] ints = toGenerateAnArray(80);
        timeToShow(1);
        RadixSort(ints);
        timeToShow(2);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 基数排序
     *
     * 基数排序从传入的数组中找到最大的那个数，并获得这个数的位数
     * 从个位数开始往桶中放入数字，然后把数字从桶中取出
     * 每次取出之后，最后需要把统计的值清除，并以此方式重复操作，直到最高位结束
     * 整个过程中，每一次排序都是稳定的，并且时间复杂度为O(d(n+r))
     * 整个算法适用于大量整数排序场景，特别适用于位数相同的数字
     * 该算法是一种非比较型整数排序算法。
     *
     * @param arr 传入需要排序的数组
     */
    public static void RadixSort(int[] arr) {
//        第一步先找到最大的那个数的
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
//       第二步获得这个数的位数
        int numLength = (""+max).length();

//        第三步开始从个位数开始往桶中放入再拿出
//        设定两个数组一个是数字桶，一个统计数字桶里面有多少个
        int[][] numBarrel = new int[10][arr.length];
        int[] countBarrel = new int[10];

        for (int j=0,n=1;j<numLength;j++,n = n*10){
//            把数字放入桶中
            for (int i =0;i<arr.length;i++){
//                先拿出来 获取位数的信息
                int digitInformation = arr[i] /n%10;
                numBarrel[digitInformation][countBarrel[digitInformation]] = arr[i];
                countBarrel[digitInformation]++;
            }

//           把数字从桶中取出
            int index =0;
            for (int i=0;i<countBarrel.length;i++){
                for (int g=0;g<countBarrel[i];g++){
                    arr[index] = numBarrel[i][g];
                    index++;
                }
//                最后需要把统计的值 清除
                countBarrel[i] =0;
            }


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
