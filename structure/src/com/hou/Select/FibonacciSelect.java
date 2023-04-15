package com.hou.Select;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 斐波那契查询法
 *
 *
 * 步骤 1.首先生成一个斐波那契数列
 *     2. 用需要去查找的数组的长度和斐波那契数列中的数逐一比对，直到斐波那契的数大于或等于需要查询的数组长度
 *     3. 如果数组长度等于，则不需要修改。不等于则需要增加数组的长度，使其等于斐波那契数的值
 *     4. 这么做是为了能利用斐波那契数列的特性 即 f(x) = f(x-1) + f(x-2)
 *     5. 开始查找，最重要的是找到 mid 即黄金分割的点 这个点用 left+ f(x-1)-1确定
 *     6. 如果要查的数比 mid 大,说明在数轴的右侧，这个时候left应该设定为 mid+1,right不变
 *     7. 因为开始查一边,右边的数轴就是f(x-2) {因为f(x-1)是左边的数轴}
 *      .1 右边数轴的黄金分割点就是 f(x-2-1)-1
 *     8. 如果要查的比 mid 小，说明在数轴的左侧，这个时候left是0,right 则是mid-1
 *     9. 查左边,左边的数轴是f(x-1),里面的黄金分割点就是 f(x-1-1)-1
 *     10. 当 mid = 要查的数的时候 就查到了，不过假如查到的是最大的数时，因为有填充的情况，要选择
 *      最小索引的传递，要不然会导致数组越界
 *
 * @author hou
 * @date 2023/01/24 10:31
 */
public class FibonacciSelect {
    public static void main(String[] args) {
        generateFibonacciSequence(10);
        int[] aa = {32,44,76,99,120,199,238,419,521};
        fibonacciSearch(aa,-88);
    }

    /**
     * 斐波那契序列生成
     *
     * @param num 要生成多少个
     * @return {@link int[]} 返回斐波那契数列
     */
    public static int[] generateFibonacciSequence(int num){
        int[] arr = new int[num];
        int a =0;
        int b = 1;
        arr[0] =1;
        arr[1] =1;
        int c= 0;
        for (int i=1;i<arr.length;i++){
            c = a+b;
            arr[i] = c;
            a = b;
            b = c;
        }
        System.out.println(Arrays.toString(arr));
        return arr;

    }

    /**
     * 斐波那契查找
     *
     * @param arr 要查找的数组
     * @param key 要查找的数字
     */
    public static int fibonacciSearch(int[] arr,int key){
          int arrleng =  arr.length;
//          先拿到斐波那契数列
          int[] Fibo = generateFibonacciSequence(10);
//
        int k = 0;

        while (true){
            k++;
            if (Fibo[k] >= arrleng) break;
        }
//        如果此时找不到和需要查找的数组长度一样的斐波那契数，那么就填充数组
        if (Fibo[k] > arrleng){
            int arr1[] = new int[Fibo[k]];
            System.arraycopy(arr,0,arr1,0,arr.length);
            Arrays.fill(arr1,arr.length,arr1.length,arr[arr.length-1]);
            arr = arr1;
        }
        System.out.println(Arrays.toString(arr));


        //现在开始正式查询
        int left = 0;
        int right = arr.length-1;
        int mid =0;
        System.out.println(mid);
//        假如说right大于 left 则说明没有查到
        while (left < right) {

            //求黄金分割点
            mid = left + Fibo[k-1]-1;
            //展示部分


            int[] intl = Arrays.copyOfRange(arr, left, mid);
            int[] intr = Arrays.copyOfRange(arr,mid+1,right);
            System.out.printf("此时左边为%s%n" +
                    "此时中间的mid为%d%n"+
                    "此时右边为%s%n",Arrays.toString(intl),arr[mid],Arrays.toString(intr));



            if (arr[mid] > key) {
//           如果出现这个值大于key的情况 就把边界调整到左半边，然后mid就等于前一半即f[k-2]
                right = mid-1;
                left = 0;
                k = k - 2;



            } else if (arr[mid] < key) {
//                当 mid 小于要 查的值
                //不变
                right = arr.length - 1;
//            因为mid已经看过了
                left = mid + 1;
                // k-1 是右边这一部分
                k = k - 1;

            } else {
                // 把最小的下标传递出去 因为扩充过数组
                System.out.println("查到了");
                if (mid < right) return mid;
                if (right < mid) return right;
            }
        }
        System.out.println("没查到");
        return -1;
    }
}
