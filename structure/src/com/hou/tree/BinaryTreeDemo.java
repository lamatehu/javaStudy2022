package com.hou.tree;

/**
 * 二叉树
 * BinaryTreeDemo类是程序的主入口，用于构造一个二叉树并调用遍历方法进行遍历
 * Person类构造二叉树的节点，提供遍历方法：前缀遍历（prefixTraverse）、中缀遍历（infixTraversal）和后缀遍历（suffixTraversal）
 * BinaryTree类是二叉树类，提供遍历方法，调用节点类的遍历方法进行遍历
 * @author hou
 * @date 2023/01/28 10:28
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        Person a = new Person(1, "小王");
        Person b = new Person(2, "小明");
        Person c = new Person(3, "小白");
        Person d = new Person(4, "小红书");
        Person e = new Person(5, "小红帽");
        a.setNextleft(b);
        a.setNextright(c);
        c.setNextleft(e);
        c.setNextright(d);
        BinaryTree binaryTree = new BinaryTree(a);
        binaryTree.prefixTraverse();
        System.out.println("--------");
        binaryTree.infixTraversal();
        System.out.println("--------");
        binaryTree.suffixTraversal();
        System.out.println("----前序查找----");
        binaryTree.beforeOrderLookup(5);
        System.out.println("-----中序查找---");
        binaryTree.inOrderToFind(5);
        System.out.println("-----后序查找---");
        binaryTree.suffixToSeach(5);
        System.out.println("删除");
        binaryTree.delPerson(3);

        binaryTree.prefixTraverse();

    }
}

/**
 * 构造节点
 *
 * @author hou
 * @date 2023/01/28 11:44
 */
class Person{
    private int id;
    private String name;
    private Person nextleft;
    private Person nextright;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person getNextleft() {
        return nextleft;
    }

    public void setNextleft(Person nextleft) {
        this.nextleft = nextleft;
    }

    public Person getNextright() {
        return nextright;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNextright(Person nextright) {
        this.nextright = nextright;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前缀遍历
     */
    public void prefixTraverse() {
        System.out.println(this.toString());
        if (this.nextleft != null) {
            this.nextleft.prefixTraverse();
        }
        if (this.nextright != null) {
            this.nextright.prefixTraverse();
        }
    }

    /**
     * 中缀遍历
     */
    public void infixTraversal() {
        if (this.nextleft != null) {
            this.nextleft.infixTraversal();
        }
        System.out.println(this);

        if (this.nextright != null) {
            this.nextright.infixTraversal();
        }
    }

    public void suffixTraversal() {
        if (this.nextleft != null) {
            this.nextleft.suffixTraversal();
        }
        if (this.nextright != null) {
            this.nextright.suffixTraversal();
        }


        System.out.println(this);
    }

    /**
     * 前序查找
     *
     * @param no 没有
     * @return {@link Person}
     */
    public Person beforeOrderSerach(int no) {
        if (this.id == no) {
            return this;
        }
        Person res = null;
        if (this.nextleft != null) {
            res = this.nextleft.beforeOrderSerach(no);

        }
        if (res != null) {
            return res;
        }
        if (this.nextright != null) {
            res = this.nextright.beforeOrderSerach(no);
        }
        return res;
    }

    /**
     * 中序查找
     *
     * @param no 查找的
     * @return {@link Person}
     */
    public Person inOrderToFind(int no) {
        Person res = null;
        if (this.nextleft != null) {
            res = this.nextleft.inOrderToFind(no);
        }
        if (res != null) {
            return res;
        }
        if (this.id == no) {
            return this;
        }
        if (this.nextright != null) {
            res = this.nextright.inOrderToFind(no);
        }
        return res;
    }

    /**
     * 后缀查找
     *
     * @return {@link Person}
     */
    public Person suffixToSeach(int no){
        Person res = null;
        if (this.nextleft != null){
            res = this.nextleft.suffixToSeach(no);
        }
        if (res != null){
            return res;
        }
        if (this.nextright != null){
            res = this.nextright.suffixToSeach(no);
        }
        if (res != null){
            return res;
        }
        if (this.id == no){
            return this;
        }
        return res;
    }

    /**
     * 删除节点
     *
     * @param no 没有
     */
    public boolean delPerson(int no){
        if (this.nextleft !=null){
            if (this.nextleft.id == no){
                this.nextleft = null;
                return true;
            }else {
                this.nextleft.delPerson(no);
            }
        }
        if (this.nextright != null){
            if (this.nextright.id ==no){
                this.nextright = null;
                return true;
            }else {
                this.nextright.delPerson(no);
            }
        }

        return false;
    }
}

/**
 * 二叉树
 *
 * @author hou
 * @date 2023/01/28 13:42
 */
class BinaryTree{
    Person root;

    public BinaryTree(Person root) {
        this.root = root;
    }

    /**
     * 前缀遍历
     */
    public void prefixTraverse(){
        if (this.root != null){
            this.root.prefixTraverse();
        }
    }

    /**
     * 中缀遍历
     */
    public void infixTraversal(){
        if (this.root !=null){
            this.root.infixTraversal();
        }
    }

    /**
     * 后缀遍历
     */
    public void suffixTraversal(){
        if (this.root!=null){
            this.root.suffixTraversal();
        }
    }

    /**
     * 前序查找
     */
    public void beforeOrderLookup(int no){
        if (root != null){
            Person person = root.beforeOrderSerach(no);
            if (person !=null){
                System.out.println(person);
            }else {
                System.out.println("没找到");
            }
        }
    }

    /**
     * 中序查找
     */
    public void inOrderToFind(int no){
        if (root != null){
            Person person = root.inOrderToFind(no);
            if (person !=null){
                System.out.println(person);
            }else {
                System.out.println("没找到");
            }
        }
    }

    /**
     * 后缀查找
     */
    public void suffixToSeach(int no){
        if (root != null){
            Person person = root.suffixToSeach(no);
            if (person !=null){
                System.out.println(person);
            }else {
                System.out.println("没找到");
            }
        }
    }

    /**
     * 删除指定节点
     *
     * @param no 传入要删除的id
     */
    public void delPerson(int no){
        if (root !=null){
            if(root.getId() == no) root = null;
            else {
                boolean b = root.delPerson(no);
                if (b) System.out.println("删除成功");
            }

        }else {
            System.out.println("树为空");
        }
    }

}
