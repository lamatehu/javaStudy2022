package com.hou.LinkList;

/**
 * 双链表演示
 *
 * @author hou
 * @date 2023/01/04 05:19
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
//        添加数据
        HeroNode1 heroNode = new HeroNode1(1, "宋江", "首领");
        HeroNode1 heroNode2 = new HeroNode1(2, "卢俊义", "哈哈哈");
        HeroNode1 heroNode3 = new HeroNode1(3, "吴用", "智多星");
        HeroNode1 heroNode6 = new HeroNode1(6, "吴用", "智多星");
        HeroNode1 heroNode9 = new HeroNode1(9, "吴用", "智多星");
        HeroNode1 heroNode4 = new HeroNode1(4, "吴用", "智多星");

//        创建链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        //doubleLinkedList.add(heroNode);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode6);

//        遍历列表
        doubleLinkedList.list();
//        修改
        doubleLinkedList.alter(2,"老卢","哈哈");
//        删除
        doubleLinkedList.del(2);
        doubleLinkedList.list();
        System.out.println("ceshi");
//        测试加入中间
        doubleLinkedList.orderInsert(heroNode4);
        doubleLinkedList.list();
//        测试加入边边
        doubleLinkedList.orderInsert(heroNode9);
        doubleLinkedList.orderInsert(heroNode);
        doubleLinkedList.list();
    }
}

/**
 * 英雄node1
 *
 * @author hou
 * @date 2023/01/04 05:19
 */
class HeroNode1 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode1 pre;
    public HeroNode1 next;

    public HeroNode1(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

/**
 * 双链表方法代码
 *
 * @author hou
 * @date 2023/01/04 06:19
 */
class DoubleLinkedList {
    private HeroNode1 head = new HeroNode1(0,"","");

    /**
     * 添加元素到双链表
     * 先找到双链表中最后一个元素
     * temp.next = 新元素
     * temp.next.pre = 最后这个元素的前元素
     */
    public void add(HeroNode1 h){
        HeroNode1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = h;
        temp.next.pre = temp;
    }

    /**
     * 删除链表中的指定元素
     * 先找到那个元素
     * 之后
     * temp.pre.next = temp.next
     * temp.next.pre = temp.pre (当下一个有元素的情况下)
     *
     */
    public void del(int no){
        if (head.next == null){
            System.out.println("链表中没有元素");
        }
        boolean flag = false;
        HeroNode1 temp = head.next;
        while (true){
            if (temp ==null){
                break;
            }
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.println("你要删除的不存在");
        }

    }

    /**
     * 修改
     *
     * @param no           编号
     * @param newHeroNode1 新英雄node1
     */
    public void alter(int no,String name,String nickName){
        if (head.next == null){
            System.out.println("为空");
        }
        HeroNode1 temp = head;
        boolean flag = false;
        while (temp.next != null){
            if (temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag == true){
            temp.name = name;
            temp.nickName = nickName;
            System.out.println("修改成功");
        }else {
            System.out.println("没有找到需要修改的编号");
        }
    }

    /**
     * 遍历列表
     *
     * @return {@link HeroNode1}
     */
    public HeroNode1 list(){
        if (head.next == null){
            System.out.println("链表为空");
        }
        HeroNode1 temp = head.next;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
        return null;
    }

    /**
     * 顺序插入
     */
    public void orderInsert(HeroNode1 heroNode1){
        if (head.next == null){
            System.out.println("链表为空");
            head.next = heroNode1;
        }
        HeroNode1 temp = head;
        boolean flag = true;
        while (true){
            if (temp.next ==null){
                System.out.println("为空");
                break;
            }
            if (temp.next.no > heroNode1.no){
                break;
            }
            else if (temp.next.no == heroNode1.no){
                System.out.println("此时相等不修改");
                flag = false;
                break;
            }
            temp  = temp.next;

        }
        if (flag){
            heroNode1.next = temp.next;
//            此时要判断一下，temp还有没有下一个元素，如果没有 则不能给下一个的pre 赋值，会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = heroNode1;
            }
            temp.next = heroNode1;
            heroNode1.pre = temp;

        }else {
            System.out.println("出现相同不修改");
        }
    }

}
