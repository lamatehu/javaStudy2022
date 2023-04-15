package com.hou.huffmanTree;

import com.hou.stack.LinkedStackDemo;

import java.awt.*;
import java.util.*;
import java.util.List;

public class testhuffman{
    public static void main(String[] args) {
        testhuff a = new testhuff(12);
        int[] arr = {2,-9,3,5,1,2,4,7};
        int temp =0;
        boolean loop = true;

        List<testhuff> nodes = new ArrayList<>();
        testhuff testhuffss = null;
        for (int i : arr) {
            testhuff node = new testhuff(i);
            nodes.add(node);
        }
        while (nodes.size() >1){
            Collections.sort(nodes);
            testhuff testhuff0 = nodes.get(0);
            testhuff testhuff1 = nodes.get(1);
            testhuffss = new testhuff(testhuff0.node + testhuff1.node);

            testhuffss.left = testhuff0;
            testhuffss.right = testhuff1;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(testhuffss);



        }
        testhuffss.preOrder();
        testhuffss.preOrder(2);

    }
}




class testhuff implements Comparable<testhuff>{
    int node;
    testhuff left;
    testhuff right;

    public testhuff(int node) {
        this.node = node;
    }

    public void preOrder(int a){
        System.out.print("-> ");
        System.out.print(node);
        if (this.left != null){
            System.out.print(" (left child: ");
            this.left.preOrder();
            System.out.print(") ");
        } else {
            System.out.print(" (left child: null) ");
        }
        if (this.right !=null){
            System.out.print(" (right child: ");
            this.right.preOrder();
            System.out.print(") ");
        } else {
            System.out.print(" (right child: null) ");
        }
    }


    public void preOrder(){
        if (this.left != null){
            this.left.preOrder();
        }
        System.out.println(node);

        if (this.right !=null){
            this.right.preOrder();
        }
    }


    @Override
    public int compareTo(testhuff o) {
        return Integer.compare(this.node,o.node);
    }
}