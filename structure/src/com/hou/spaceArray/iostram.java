package com.hou.spaceArray;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class iostram {
//    文件写入和读取

    public static void outputStreamFile(int[][] ints) {

//        创建文件把内容写到文件之中
        try {
            File file = new File("a.txt");
            if (file.createNewFile()) {
                System.out.println("文件创建成功");
            }
//            使用缓冲字节流写入文件
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[i].length; j++) {
                    bufferedWriter.write(String.valueOf(ints[i][j]));
                    bufferedWriter.write("\t");
                }
                bufferedWriter.newLine();
            }
//            刷新缓冲流并且关闭连接
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //从spacearray 调用方法拿到稀疏数组
        //spaceArray spaceArray = new spaceArray();
        //int[][] ints = spaceArray.test22();

        //把字符串输出出去
        //outputStreamFile(ints);
        //把字符串输入进来
        inputStreamFile();

    }

    public static void inputStreamFile() {
//        读取a.txt
        String line;
        int sum = 0;
        Path path = Paths.get("a.txt");
        try {
//            先获取行数
            long count = Files.lines(path).count();
            int count1 = (int) count;
            System.out.println("行数" + count1 + " " + count);
            int[][] spaceArray3 = new int[count1][3];
            BufferedReader bufferedReader = new BufferedReader(new FileReader("a.txt"));
            while ((line = bufferedReader.readLine()) != null) {

                String[] word = line.split("\t");
                for (int i = 0; i < word.length; i++) {
                    spaceArray3[sum][i] = new Integer(word[i]);
                }
                sum++;


            }

            for (int[] ints : spaceArray3) {
                for (int anInt : ints) {
                    System.out.print(anInt + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
