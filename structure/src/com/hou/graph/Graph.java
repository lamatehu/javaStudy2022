package com.hou.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 图
 *
 * @author hou
 * @date 2023/03/09 02:29
 */
public class Graph {


    public static void main(String[] args) {
        String[] vertexs = {"A","B","C","D","E"};
        Graph graph = new Graph(5);


        //添加到vertex
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }

        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(1,2,1);
        graph.showGraph();
//        graph.dfs();
        graph.bsf();
    }



    int[][] edges;
    ArrayList<String> vertexList;
    int numOfEdges;
    int weight;
    int numOfVertex;
    boolean[] isVisited;

    public Graph(int n) {
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>();
        this.numOfEdges = 0;
        this.numOfVertex = n;
        isVisited = new boolean[n];

    }

    /**
     * 广度优先算法
     */
    public void bsf() {
        for (int i=0;i<getNumOfVertex();i++){
            //如果没有访问过这个节点
            if (!isVisited[i]){
                bsf(i);
            }
        }
    }

    /**
     * 广度优先算法
     *
     * @param v1
     */
    public void bsf(int v1){
        //先打印这个节点
        System.out.print(getValueByIndex(v1) +"->");
        //把这个节点设定为true
        isVisited[v1] = true;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(v1);
        int u; //邻居节点
        int w; //队列头节点
        while (list.isEmpty()){
            //删除队列里的这个节点
            w = list.removeFirst();
            //获得下一个节点
            u = getFirstNeighbor(w);


            if (u !=-1){
                // 如果访问过，就获取这一行下一个节点
                if (isVisited[u]){
                    w = getNextNeighbor(w,u);
                }
                //如果u没有被访问过,就打印出来并添加到队列中
                System.out.print(getValueByIndex(u) +"->");
                isVisited[u] = true;
                //最后加入到队列的末尾
                list.addLast(u);
            }
        }
    }



















    /**
     * 深度优先算法
     *
     * @param isVisted 是否被访问过
     * @param v1       v1
     */
    public void dfs(boolean[] isVisted,int i){
        System.out.print(getValueByIndex(i)+"->");
        isVisted[i] = true;
        //第一步获取它第一个邻居
        int firstNeighbor = getFirstNeighbor(i);
        //第二步 设置为访问过

        //第三步 判断第一个邻居在哪里
        while (firstNeighbor !=-1){
            //这里有两种情况，一种是获取的第一个节点被访问过
            if (!isVisted[firstNeighbor]){
                //如果这个节点刚好没有被访问过，则递归访问
                dfs(isVisted,firstNeighbor);
            }
            // 如果这个节点没有被访问过,则找下一个邻居
            firstNeighbor = getNextNeighbor(i,firstNeighbor);
        }
    }

    /**
     * dfs 重载方法 要遍历到每个节点
     */
    public void dfs(){
        for (int i= 0;i<numOfVertex;i++){
            // 如果这个节点没有被访问，则
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }


    /**
     * 得到第一个邻居
     *
     * @param v1 v1
     * @return int
     */
    public int getFirstNeighbor(int v1){
        //从0开始向后查找，是否有1的点，这个点就是下一个邻居
        for (int i=0;i<vertexList.size();i++){
            if (edges[v1][i] == 1){
                //如果这个节点没有遍历过 则返回
                if (isVisited[i]) return i;

            }
        }
        // 否则就返回-1
        return -1;
    }

    /**
     * 得到下一个邻居
     *
     * @param v1 v1
     * @param v2 v2
     * @return int
     */
    public int getNextNeighbor(int v1,int v2){
        for (int i=v2;i<numOfVertex;i++){
            if (edges[v1][i] == 1){
                //如果这个节点没有被访问过，则返回这个下标
                if (!isVisited[i]) return i;
            }
        }
        return -1;
    }





    /**
     * 返回顶点
     *
     * @return int
     */
    public int getNumOfVertex(){
        return numOfVertex;
    }

    /**
     * 展示图
     */
    public void showGraph(){
        for (int[] edge : edges) {
            System.err.println(Arrays.toString(edge));
        }
    }


    /**
     * 获取图中某个节点（vertex）的值
     *
     * @param vertex 顶点
     * @return {@link String}
     */
    public String getValueByIndex(int vertex){
        if (vertex > numOfVertex || vertex <0){
            return null;
        }
        return vertexList.get(vertex);
    }



    /**
     * 边有多少
     *
     *
     * @return int 返回总共有多少个边
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 获得权值
     * 返回该边的权重值。
     * @param v1 v1
     * @param v2 v2
     * @return int
     */
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }


    /**
     * 插入边缘 节点
     *
     * @param v1     v1 节点
     * @param v2     v2 节点
     * @param weight 权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        //因为是无向图，所以两边都要给值
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 插入顶点
     *
     * @param vertex 节点
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }


}
