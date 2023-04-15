package com.hou.tree;

/**
 * 用数组模拟二叉树的遍历
 * 前序中序
 *
 * @author hou
 * @date 2023/01/29 14:33
 */
public class BinaryTreeArrayDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BinaryTreeArray binaryTreeArray = new BinaryTreeArray(arr);
        binaryTreeArray.preOrder();
    }
}

/**
 * 顺序遍历二叉树
 *
 * @author hou
 * @date 2023/01/29 02:35
 */
class BinaryTreeArray{
    int[] arr;


    public BinaryTreeArray(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载
     */
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 遍历数组二叉树
     *  当输出语句在 前面时，就是前序遍历
     *  当输出语句在 中间时，就是中序遍历
     *  当输出语句在 后面时，就是后序遍历
     * 左子节点 2n+1
     * 右子节点 2n+2
     * 上一节点 (n-1)/2
     * @param index 位置
     */
    public void preOrder(int index){
        if (arr == null || arr.length == 0){
            System.out.println("数组为空");
            return;
        }

        int length = arr.length;
        System.out.println(arr[index]);
        //向左遍历
        if ((2*index+1) < arr.length){
            preOrder(2*index+1);
        }


        //向右遍历
        if ((2*index+2) < arr.length){
            preOrder(2*index+2);
        }

    }
}
