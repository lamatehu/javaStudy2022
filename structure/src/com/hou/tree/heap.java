package com.hou.tree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 堆排序
 *
 * @author hou
 * @date 2023/02/01 18:52
 */
public class heap {
    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 5, 9};
        heap heap = new heap();
        int[] ints = heap.toGenerateAnArray(80000000);
        heap.timeToShow(1);
        heap.sort(ints);
        heap.timeToShow(2);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * 先对数组进行初始化堆
     * 之后再一个个取出最大的值
     *
     * @param arr 加勒比海盗
     */
    private void sort(int[] arr) {
        // =====  1. 构造初始堆
        // 从第一个非叶子节点开始调整
        // 4,9,8,5,6
        //  adjustHeap(arr, arr.length / 2 - 1, arr.length);

        // 循环调整
        // 从第一个非叶子节点开始调整，自低向上
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap1(arr, i, arr.length);
        }
        // 第一轮调整了 3 个堆后：结果为：9，6,8,5,4
        // System.out.println(Arrays.toString(arr));

        // 2. 将堆顶元素与末尾元素进行交换，然后再重新调整
        int temp = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];  // j 是末尾元素
            arr[j] = arr[0];
            arr[0] = temp;
            // 这里是从第一个节点开始: 不是构建初始堆了
            // 如果
            adjustHeap1(arr, 0, j);
        }
        //System.out.println(Arrays.toString(arr));
    }

    /**
     * 调整堆
     *
     * @param arr    要的数组
     * @param i      非叶子节点，以此节点为基础，将它、它的左、右，调整为一个大顶堆
     * @param length 需要排序的数组长度
     */
    private void adjustHeap1(int[] arr, int i, int length) {
        // 难点是将当前的堆调整之后，影响了它后面节点堆的混乱，如何继续对影响的堆进行调整
        // 所以第一步中：是额外循环的从 低向上调整的
        //    第三步中：就是本代码的，从上到下调整的；这个很重要，一定要明白
        int temp = arr[i];
        // 从传入节点的左节点开始处理，下一次则是以该节点为顶堆的左节点进行调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            // 要将这三个数（堆），调整为一个大顶堆
            // i 的左节点小于右节点
            // k+1 < length : 当调整长度为 2 时，也就是数组的前两个元素，其实它没有第三个节点了，就不能走这个判定
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 右边的大，则将 k 变成最大的那一个
            }
            // 如果左右中最大的一个数，比 i 大。则调整它
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k; // i 记录被调整后的索引。
            } else {
                break;
                // 由于初始堆，就已经是大顶堆了，每个子堆的顶，都是比他的左右两个大的
                // 当这里没有进行调整的话，那么就可以直接退出了
                // 如果上面进行了调整。那么在初始堆之后，每次都是从 0 节点开始 自左到右，自上而下调整的
                //    就会一层一层的往下进行调整
            }
        }
        arr[i] = temp;
    }


    /**
     * 时间显示
     *
     * @param i 第几次的时间
     */
    public void timeToShow(int i) {
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
    public int[] toGenerateAnArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        return arr;
    }


}
