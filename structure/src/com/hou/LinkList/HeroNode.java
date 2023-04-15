package com.hou.LinkList;


import java.util.Stack;

/**
 * 节点
 *
 * @author hou
 * @date 2023/01/02 03:17
 */
public class HeroNode {
    //
    public int heroNo;
    public String heroName;
    public String heroNickName;
    public HeroNode next;

    public HeroNode(int heroNo, String heroName, String heroNickName) {
        this.heroNo = heroNo;
        this.heroName = heroName;
        this.heroNickName = heroNickName;
    }

    @Override
//    这里需要注意，当遍历时，不要显示next
    public String toString() {
        return "HeroNode{" +
                "heroNo='" + heroNo + '\'' +
                ", heroName='" + heroName + '\'' +
                ", heroNickName='" + heroNickName + '\'' +
//                ", next=" + next +
//                '
                '}';
    }
}

/**
 * 英雄链表的相关方法
 *
 * @author hou
 * @date 2023/01/02 03:22
 */
class HeroLinkList {
    /**
     * 头
     */ //    先创建一个头指针
    private HeroNode head = new HeroNode(0, "", "");

    //        先判断空指针在哪里
    public void addHeroNode(HeroNode heroNode) {
//    先创建一个temp 辅助指针来遍历
        HeroNode temp = head;
//        寻找下一个next为null的节点，之后把新的节点放上去
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    //    显示链表
    public void showHeroLinked(HeroNode head) {
//        创建一个temp 辅助指针来遍历
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.toString());
        }
    }


    /**
     * 顺序添加英雄链表
     */
    public void inOrderAddHeroList(HeroNode heroNode) {
//        判断heroNo 编号的位置
        HeroNode temp = head;
        boolean flag = true;
        while (flag) {
//            如果指针的编号大于插入的编号，那么就应该把这个编号插到前面
//           如果头指针后面为空 ，直接添加
            if (temp.next == null) break;
//            如果后一个大于前一个则可以插入
            if (temp.next.heroNo > heroNode.heroNo) {
                break;
//                如果编号存在
            } else if (temp.next.heroNo == heroNode.heroNo) {
                flag = false;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            heroNode.next = temp.next;
            temp.next = heroNode;
        } else {
            System.out.println("编号已存在 停止添加" + heroNode.heroNo);
        }


    }

    /**
     * 改变链表节点
     *
     * @param newHeroNode 要修改的英雄节点
     */
    public void alterLinkedListHeroNode(HeroNode newHeroNode) {
//        判断是否为空链表

        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.heroNo == newHeroNode.heroNo) {
                flag = true;
                break;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("你要修改的是" + newHeroNode.heroNo);
            temp.heroName = newHeroNode.heroName;
            temp.heroNickName = newHeroNode.heroNickName;
            System.out.println("修改成功");
        } else {
            System.out.println("不存在");
        }
    }

    public void removeHeroListNode(int heroNo) {
        if (head.next == null) {
            System.out.println("目前链表为空");
        }
        HeroNode temp = head;
        while (true) {
//            如果值对的上
            if (temp.next.heroNo == heroNo) {
                temp.next = temp.next.next;
                System.out.println("删除成功");
                break;
            }
            if (temp.next == null) {
                System.out.println("没有找到" + heroNo);
            }
            temp = temp.next;

        }


    }

    /**
     * 求链表中一共有多少个节点
     *
     * @return int 返回的是链表中一共有多少个节点
     */
    public int getLength() {
//        定义头节点
        HeroNode temp = head;
        int sum = 0;
        while (true) {
            if (temp.next == null) break;
            sum++;
            temp = temp.next;
        }
        return sum;
    }


    /**
     * 查找链表中倒数的第k个节点
     * <p>
     * 先找到链表中最后的一个节点
     * 然后再 全部节点-k
     *
     * @param k k
     * @return int
     * @return {@link HeroNode}
     */
    public HeroNode serchSingleBottomInTable(int k) {
        if (head.next == null) System.out.println("链表为空");
        HeroNode temp = head;
        int length = 0;

        while (true) {
            if (temp.next == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        temp = head;
        if (length - k < 0) {
            System.out.println("此链表出现越界");
            return head;
        }
        for (int i = 0; i < length + 1 - k; i++) {
            temp = temp.next;
        }
        return temp;

    }

    /**
     * 反向生成链表
     *
     * 思路:
     * 设定一个暂存节点 next 把 第一个链第二个节点暂时保存
     * 第一个链的第二个节点设置为反向链表的第一个节点
     * 反向链表的第一个节点设置为 第一个链的第一个节点
     * 将 指针指向 next 重复操作
     *
     * @param head 头
     * @return {@link HeroNode}
     */
    public HeroNode reverseALinkedList(HeroNode head) {
        HeroNode front = head.next;
        HeroNode re = new HeroNode(0, "", "");
        HeroNode next = null;
        if (front.next == null || front.next.next == null) {
            System.out.println("无法反转，因为没有两个元素");
            return null;
        }
        while (front != null) {
//        第一步: 先保存第一个链的第二个元素
            next = front.next;
//        第二步: 把第一个链的第一个元素的下一个元素设定为 第二个链的第一个元素
            front.next = re.next;
//            第三步: 把第二个链的第一个元素 设定为 第一个链的第一个元素
            re.next = front;
//            最后把第一个链的 第一个元素 设定为 第一个链的第二个元素
            front = next;
            System.out.println("哈哈");
        }
//        都完成后将 后一个的下一个 指向 头的下一个
        head.next = re.next;
        return head;
    }

    public HeroNode getHead() {
        return head;
    }

    /**
     * 反向打印
     * 使用的是栈的方法
     * 先把链表中的元素存到栈里
     * 之后再把他们遍历打印
     *
     * @param head 头
     */
    public void reservePrint(HeroNode head) {
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("链表为空，不能打印");
        }
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }

    }
}


/**
 * 英雄链表的测试
 *
 * @author hou
 * @date 2023/01/02 03:39
 */
class HeroLinkListTest {
    public static void main(String[] args) {
        HeroNode heroNode = new HeroNode(1, "宋江", "首领");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroLinkList heroLinkList = new HeroLinkList();
        HeroNode head = heroLinkList.getHead();

        heroLinkList.addHeroNode(heroNode);
        heroLinkList.addHeroNode(heroNode3);
        System.out.println("n");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "哈哈哈");

        heroLinkList.inOrderAddHeroList(heroNode2);

        System.out.println("n");
        heroLinkList.showHeroLinked(head);
        HeroNode heroNode6 = new HeroNode(6, "吴", "智多星");
        heroLinkList.inOrderAddHeroList(heroNode6);
        heroLinkList.showHeroLinked(head);

        //修改节点
        HeroNode heroNode6l = new HeroNode(6, "吴__", "智多星__");
        heroLinkList.alterLinkedListHeroNode(heroNode6l);
        heroLinkList.showHeroLinked(head);
        //删除节点

        heroLinkList.removeHeroListNode(6);
        heroLinkList.showHeroLinked(head);

//        查看目前链表中节点的数量
        int sum = heroLinkList.getLength();
        System.out.println("目前链表中的节点数量为" + sum);

        HeroNode heroNode1 = heroLinkList.serchSingleBottomInTable(1);
        System.out.println(heroNode1);
//    反转节点
//        HeroNode heroNode4 = heroLinkList.reverseALinkedList(head);
//        反向打印
        System.out.println("反向打印");
        heroLinkList.reservePrint(head);


    }
}