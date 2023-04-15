package com.hou.AlgorithmBox;

/**
 * 汉诺塔问题
 *
 * @author hou
 * @date 2023/03/10 14:43
 */
public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.hanoitower(3,'A','B','C');

    }

    /**
     * hanoitower
     *
     * @param num 汉诺塔的层数
     */
    public void hanoitower(int num,char a,char b,char c){
        if (num == 1){
            // 只有一块的情况下直接a-c
            System.out.println("第:"+num+"A->C");
        }else {
            //有很多块的情况下我们也只当3块看
            hanoitower(num-1,a,c,b);
            System.out.println(num+":"+a+"->"+c);
            hanoitower(num-1,b,c,a);
            System.out.println(num+":"+b+"->"+c);
            hanoitower(num-1,a,c,b);
        }
    }
}
