package com.hou.huffmanTree;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树的实例
 *
 * @author hou
 * @date 2023/02/03 01:38
 */
public class huffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        huffmanTree huffmanTree = new huffmanTree();
        Node root = huffmanTree.huffmanTreeGenerate(arr);
        huffmanTree.preOrder(root);
    }

    /**
     * 哈夫曼树生成
     *
     * @param arr 数组
     * @return {@link Node} 返回的是哈夫曼树
     */
    public Node huffmanTreeGenerate(int[] arr) {
        // 第一步把数组变成集合对象 且每个元素都变成Node对象
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            Node node = new Node(i);
            nodes.add(node);
        }

        while (nodes.size() > 1) {
            //第二步 对这个集合排序
            Collections.sort(nodes);
            System.out.println(nodes);

            //第三步 把第一个和第二个 元素相加 组成一个新树
            Node nodeLeft = nodes.get(0);
            Node nodeRight = nodes.get(1);
            Node root = new Node(nodeLeft.value + nodeRight.value);
            root.nextLeft = nodeLeft;
            root.nextRight = nodeRight;
            // 在集合中删除这两个元素，因为已经挂在了这个root树上
            nodes.remove(0);

            nodes.remove(0);

            // 将 root 加入到 nodes 中
            nodes.add(root);
        }
        return nodes.get(0);


    }


    /**
     * 中序
     *
     * @param root 根
     */
    public void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空");
        }
    }
}

class Node implements Comparable<Node> {
    Node node;
    Node nextLeft;
    Node nextRight;
    int value;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 前序遍历 中 左 右
     */
    public void preOrder() {
        System.out.println(this.value);
        if (this.nextLeft != null) {
            this.nextLeft.preOrder();
        }
        if (this.nextRight != null) {
            this.nextRight.preOrder();
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
