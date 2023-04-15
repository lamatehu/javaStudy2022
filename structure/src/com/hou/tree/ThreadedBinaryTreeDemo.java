package com.hou.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedPerson person = new ThreadedPerson(1, "哈哈");
        ThreadedPerson person1 = new ThreadedPerson(2,"小牛");
        ThreadedPerson person2 = new ThreadedPerson(3,"很少很少");
        ThreadedPerson person3 = new ThreadedPerson(4,"露露");
        ThreadedPerson person4 = new ThreadedPerson(5,"讲解");
        ThreadedPerson person5 = new ThreadedPerson(6, "baba");
        person.setNextleft(person1);
        person.setNextright(person2);
        person1.setNextleft(person3);
        person1.setNextright(person4);
        person2.setNextleft(person5);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(person);
        threadedBinaryTree.infixTraversal();
//        threadedBinaryTree.sequenceCluesInTree();
//        threadedBinaryTree.huaerQuadtreeTraversalCues(person);
//        System.out.println(person4.getLeftType());
        //正确的
        System.out.println("----");
        threadedBinaryTree.preOrderThreadeNodes(person);
        System.out.println("----");
        //threadedBinaryTree.preorderTraversingBinaryTree(person);
        System.out.println("----");
    }
}



/**
 * 线索二叉树
 *
 * @author hou
 * @date 2023/01/29 17:06
 */
class ThreadedBinaryTree extends BinaryTree{
    private Person LeftType;
    private Person RightType;
    public ThreadedPerson pre;
    private ThreadedPerson root;
    //因为有root了 所以不用再定义
    public ThreadedBinaryTree(ThreadedPerson root) {
        super(root);
        this.root = root;
    }
    public ThreadedPerson getThreadPerson(Person person){
        return (ThreadedPerson)person;
    }

    public Person getLeftType() {
        return LeftType;
    }

    public void setLeftType(Person leftType) {
        LeftType = leftType;
    }

    /**
     * 重载线索化
     */
    public void sequenceCluesInTree(){
        System.out.println("开始线索化");
        sequenceCluesInTree(this.root);
        System.out.println("线索化成功");
    }

    /**
     * 中序遍历线索化二叉树
     *
     * 先找到第一个节点
     *
     *
     * @param person 人
     */
    public void huaerQuadtreeTraversalCues(ThreadedPerson person){
        ThreadedPerson node = person;
        while (node != null){

            //先找到第一个节点
            while (node.getLeftType() !=1){
                node = node.getNextleft();
            }
            System.out.println(node);
            //找到第一个节点后，我们就可以根据type的值判断是否有后继节点
            while (node.getRightType() == 1){
                node = node.getNextright();
                System.out.println(node);
            }
            //因为没有了后继节点，所有nextright就是空，会跳出循环
            node = node.getNextright();
        }
   }

    /**
     * 中序线索化二叉树
     *
     * @param person 人
     */
    public void sequenceCluesInTree(ThreadedPerson person){

        // 如果传进来的为空直接返回
        if (person == null){
            return;
        }
        sequenceCluesInTree(person.getNextleft());

//        如果为空的话，可以为它设定前驱节点
        if (person.getNextleft() == null){
            person.setNextleft(pre);
            person.setLeftType(1);
        }

//        如果右节点为空，就是后继节点
        if (pre!=null && pre.getNextright() == null){
            pre.setNextright(person);
            pre.setRightType(1);
        }
        pre = person;

        sequenceCluesInTree(person.getNextright());
    }


    /**
     * 前序线索化二叉树
     *
     * @param person 人
     */
    public void preOrderThreadeNodes(ThreadedPerson person){
        // 如果此时person为空则跳出递归
        if (person == null){
            return;
        }



        System.out.println(person);
        //向左遍历 左节点线索化是他的前驱节点
        if (person.getNextleft() == null){
            //说明没有左节点，可以设置前驱节点
            person.setNextleft(pre);
            person.setLeftType(1);
        }
        //右节点的前驱节点是左节点 如果pre的右节点是空的，那么设置他的后继节点
        if (pre !=null &&pre.getNextright() ==null){
            pre.setNextright(person);
            pre.setRightType(1);
        }

        // 让pre = person
        pre =  person;
        //如果把这两行移到前面，就是后续线索化
        if (person.getLeftType() ==0){
            preOrderThreadeNodes(person.getNextleft());
        }
        if (person.getRightType() ==0){
            preOrderThreadeNodes(person.getNextright());
        }

    }


    /**
     * 前序遍历二叉树
     * 思路 因为前序是 中左右
     * 那么第一次只要向左找没有线索化的节点 直到遍历到线索化的节点
     * 这个时候再看它的右节点 是否为线索化节点，
     * 是的话就接着向右遍历 直到不是线索化节点
     * 这个时候跳过这个节点，重复上面的操作
     *
     * @param person 人
     */
    public void preorderTraversingBinaryTree(ThreadedPerson person){
        ThreadedPerson node = person;
        while (node != null){
            System.out.println(node);
            while (node.getLeftType() == 0){

                node = node.getNextleft();
                System.out.println(node);
            }
            while (node.getRightType() ==1){
                node = node.getNextright();
                System.out.println(node);
            }

            node = node.getNextright();
        }
    }

}



/**
 * 重写 Person 实体类
 *
 * @author hou
 * @date 2023/01/29 17:17
 */
class ThreadedPerson extends Person{
    private int LeftType;
    private int RightType;
    private Person pre;

    @Override
    public ThreadedPerson getNextright() {
        ThreadedPerson nextright = (ThreadedPerson)super.getNextright();
        return nextright;
    }

    @Override
    public ThreadedPerson getNextleft() {
       ThreadedPerson person = (ThreadedPerson)super.getNextleft();
        return person;
    }

    public ThreadedPerson(int id, String name) {
        super(id, name);
    }

    public int getLeftType() {
        return LeftType;
    }

    public void setLeftType(int leftType) {
        LeftType = leftType;
    }

    public int getRightType() {
        return RightType;
    }

    public void setRightType(int rightType) {
        RightType = rightType;
    }

    public Person getPre() {
        return pre;
    }

    public void setPre(Person pre) {
        this.pre = pre;
    }
}

