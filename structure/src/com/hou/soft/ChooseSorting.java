package com.hou.soft;

import sun.text.resources.FormatData;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 * 选择排序 就是在每次循环的时候把数组中最小的值找出来放到数组的最左边，
 * 把最左边的那个值放到最小值的位置上，之后再寻找数组中次小的值，直到找不到为止
 *
 * @author hou
 * @date 2023/01/16 12:57
 */
public class ChooseSorting {

    public static void main(String[] args) {
//        int[] arr = {101,34,119,88,99,23,-19,-34};
        timeToShow(1);
        int[] ints = ChooseSortingSimple(toGenerateAnArray(80000));
        timeToShow(2);
        //System.out.println(Arrays.toString(ints));

    }

    /**
     * 简单选择排序
     * 选择排序是一种简单的排序算法。该算法的基本思想是每次从待排序的数据中找出最小(或最大)的一个元素，存放在序列的起始位置(或结尾)，直到全部待排序的数据排完。
     * <p>
     * 选择排序的流程：
     * <p>
     * 首先在未排序的数列中找到最小(或最大)元素，存放到排序序列的起始位置
     * 然后，再从剩余未排序的元素中继续寻找最小(或最大)元素，然后放到已排序序列的末尾
     * 重复第二步，直到所有元素均排序完毕。
     * 选择排序是不稳定的排序算法，时间复杂度为 O(n²)。
     *
     * @param arr 传入需要排序的数组
     * @return {@link int[]}
     */
    public static int[] ChooseSortingSimple(int[] arr) {
        long ci = 0; // 看一看算法执行了多少次
        int index;
        int minNum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            index = i;
            minNum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < minNum) {
//                    如果遇到比最小数字还小的情况，记录这个数字的位置
                    index = j;
                    minNum = arr[j];
                }
                ci++;
            }
//            把获得最小值和数组最左边的对调一下 i为当此循环的最左边的一个
            if (index != i) {
//                调换两个值的位置
                arr[index] = arr[i];
                arr[i] = minNum;

            } else {
                System.out.println("提前中止，因为排列完成");
                break;
            }
        }
        System.out.println("一共用时" + ci);
        return arr;
    }

    /**
     * 时间显示
     *
     * @param i 第几次的时间
     */
    public static void timeToShow(int i) {
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        String format = simpleDateFormat.format(date1);
        System.out.println("第" + i + " " + format);
    }

    /**
     * 生成一个测试算法的数组
     *
     * @param n 传入需要生成多少个数据
     * @return {@link int[]} 返回这个数组
     */
    public static int[] toGenerateAnArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }
}
