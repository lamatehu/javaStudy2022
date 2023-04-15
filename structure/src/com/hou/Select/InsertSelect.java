package com.hou.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插值排序
 *
 * @author hou
 * @date 2023/01/24 08:59
 */
public class InsertSelect {
    public static void main(String[] args) {
//        先创建一组数据
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
// 开始查找
        interpolationToFind(arr, 0, arr.length - 1, 78);
    }

    /**
     * 插值查找
     *
     * @param arr   数组
     * @param left  左边界
     * @param right 右边界
     * @param num   需要查找的数据
     * @return int
     */
    public static List<Integer> interpolationToFind(int[] arr, int left, int right, int num) {

        //        防止查找的时候数组不越界
        if (left > right || num < arr[0] || num > arr[arr.length - 1]) {
            System.out.println(arr[arr.length - 1]);
            System.out.println("找不到");
            return null;
        }
        //自适应的 可以减少查找的次数
        /*
         * 插值查找公式: mid = low + (high - low) * (search_value - array[low]) / (array[high] - array[low])
         *
         * 其中:
         * - low 和 high 是数组中当前查找范围的下标
         * - search_value 是要查找的值
         * - array[low] 和 array[high] 分别是数组中当前查找范围内的最小值和最大值
         *
         * 插值查找的基本原理:
         * - 在一个有序数组中，如果要查找的元素值越接近数组中间元素的值，则它可能出现在数组中间位置附近，而不是在数组的最左端或最右端。
         * - 因此，我们可以通过计算要查找的值在整个数组中所处的位置，来确定在数组中应该查找的位置。
         */
        int mid = left + (right - left) * (num - arr[left]) / (arr[right] - arr[left]);
        System.out.println(mid);
        if (arr[mid] < num) {
            return interpolationToFind(arr, mid + 1, right, num);
        } else if (arr[mid] > num) {
            return interpolationToFind(arr, left, mid, num);
        } else {
//            这个时候就拿到了这个值
            List<Integer> aa = new ArrayList<Integer>();

            int k = 1;
            while (true) {
                if (arr[mid] != arr[mid - k]) {
                    break;
                }
                aa.add(mid - k);
                k++;
            }
            aa.add(mid);
            k = 1;
            while (true) {
                if (arr[mid] != arr[mid + k]) {
                    break;
                }
                aa.add(mid + k);
                k++;
            }
            System.out.println(aa);
            return aa;
        }
    }
}
