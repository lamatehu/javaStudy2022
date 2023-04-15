package com.hou.huffmanTree;

import java.io.*;
import java.util.*;

/**
 * 哈夫曼编码
 * <p>
 * 1. 先统计这段文本每个字符有多少个
 * 2. 再根据这个生成哈夫曼树
 *
 * @author hou
 * @date 2023/03/02 17:26
 */
public class HuffmanEncoder {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";

//        //使用霍夫曼编码的方法
        byte[] bytes = huffmanCode(str.getBytes());
        huffmanZipFile("C://Users//959505084//Pictures//Camera Roll//vladstudio_xmas_windows_wallpaper.jpg","C://Users//959505084//Pictures//Camera Roll//vladstudio_blank_canvas_wallpaper.zip");
        huffmanDecompressFile("C://Users//959505084//Pictures//Camera Roll//vladstudio_blank_canvas_wallpaper.zip","C://Users//959505084//Pictures//Camera Roll//vladstudio_blank_canvas_wallpaper211.jpg");
    }

    /**
     * 霍夫曼编码
     * 把huffman转码封装成一个方法
     *
     * @param bytes 字节
     * @return {@link byte[]}
     */
    private static byte[] huffmanCode(byte[] bytes) {

        // 1. 统计每个字符的出场次数
        List<Node1> node1s = countCharacters(bytes);
        // 2. 根据每个字符的出场次数，构建huffman树
        Node1 huffmanTree = createHuffmanTree(node1s);
        // 3. 把huffmantree中叶子结点的data和weidth提取到map中,成为编码表
        Map<String, String> codes = getCodes(huffmanTree);
        // 4.根据编码表对 要编码的文本编码

        byte[] bytes1 = zipCode(codes,bytes);
        //System.out.println(bytes1);


        //1. 进行解码
        byte[] referce = reference(codes, bytes1);
        //referce
        //输出观察处
        System.out.println(new String(referce));
        return bytes1;

    }


    /**
     * 使用Huffman编码压缩文件
     * @param sourceFilePath 需要压缩的文件路径
     * @param compressedFilePath 压缩后的文件路径
     */
    private static void huffmanZipFile(String sourceFilePath, String compressedFilePath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            // 1.读取文件，变成一个数组
            fis = new FileInputStream(sourceFilePath);
            byte[] filebytes = new byte[fis.available()];
            fis.read(filebytes);

            // 2.将文件内容进行Huffman编码
            byte[] huffmancode = huffmanCode(filebytes);

            fos = new FileOutputStream(compressedFilePath);
            // 获取对象输出流
            oos = new ObjectOutputStream(fos);

            // 3.将Huffman编码的内容和编码表输出到压缩文件中
            oos.writeObject(huffmancode);
            oos.writeObject(codes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("文件关闭失败");
            }
        }
    }


    /**
     * 霍夫曼解压文件
     *
     * @param sourceFilePath     源文件路径
     * @param compressedFilePath 压缩文件路径
     */
    private static void huffmanDecompressFile(String sourceFilePath,String compressedFilePath){
        FileInputStream fIS = null;
        ObjectInputStream oIS = null;
        FileOutputStream fOS = null;

        try {
            // 第一步，拿到文件的内容，文件里有两部分，一部分是编码后的文件，另一部分是编码集
            fIS = new FileInputStream(sourceFilePath);
            oIS= new ObjectInputStream(fIS);
            byte[] huffmanCode = (byte[])oIS.readObject();
            Map<String,String> codes = (Map<String,String>)oIS.readObject();
            System.out.println(codes);
            // 第二步，进行解码操作
            byte[] referce = reference(codes,huffmanCode);
            // 第三步,将解码好的文件变成一个文件
            System.out.println(referce.length);
            fOS = new FileOutputStream(compressedFilePath);
            fOS.write(referce);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fOS.close();
                oIS.close();
                fIS.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("解码文件关闭时出错");
            }


        }


    }

    /**
     * 数字符
     * 将字符串分割并统计他们各有多少个
     * 返回一个list对象
     *
     * @param bytes 传递过来的是字符串的字节值
     * @return {@link List}<{@link Node1}>
     */
    public static List<Node1> countCharacters(byte[] bytes) {

        Map<Integer, Integer> datewidthHashMap = new HashMap<>();
        for (byte aByte : bytes) {
            Integer b = (int) aByte;
            Integer count = datewidthHashMap.get(b);
            if (count == null) {
                datewidthHashMap.put(b, 1);

            } else {
                datewidthHashMap.put(b, count + 1);
            }
        }
        List<Node1> node1s = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = datewidthHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            Node1 node1 = new Node1(entry.getValue(), entry.getKey().byteValue());
            node1s.add(node1);
        }

        return node1s;


    }


    /**
     * 创建哈夫曼树
     *
     * @param lists 列表
     * @return {@link Node1}
     */
    public static Node1 createHuffmanTree(List<Node1> lists) {
        while (lists.size() > 1) {
            Collections.sort(lists);
            Node1 node1 = lists.get(0);
            Node1 node11 = lists.get(1);
            Node1 node12 = new Node1(node1.weidth + node11.weidth, null);
            node12.left = node1;
            node12.right = node11;
            lists.remove(node11);
            lists.remove(node1);
            lists.add(node12);
        }
        return lists.get(0);


    }

    //创建两个静态变量
    static StringBuilder stringBuilder = new StringBuilder();
    static Map<String, String> codes = new HashMap<>();

    /**
     * 通过huffmantree 获取编码
     *
     * @param node1         node1
     * @param stringBuilder 字符串生成器
     * @param code          代码
     */
    public static void getCodes(Node1 node1, StringBuilder stringBuilder, String code) {
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node1 != null) {
            if (node1.date == null) {
                getCodes(node1.left, stringBuilder2, "0");
                getCodes(node1.right, stringBuilder2, "1");
            } else {

                codes.put(node1.date.toString(), stringBuilder2.toString());
            }
        }

    }

    /**
     * 通过huffmantree 获取编码(重载方法)
     *
     * @param node1 node1
     */
    public static Map<String, String> getCodes(Node1 node1) {
        //清除两个静态变量的
        stringBuilder.setLength(0);
        codes.clear();
        if (node1 == null) {
            System.out.println("这个结点为空");
            return null;
        }
        getCodes(node1.left, stringBuilder, "0");
        getCodes(node1.right, stringBuilder, "1");
        return codes;
    }


    /**
     * 将给定字符串str通过Huffman编码表map进行压缩，并返回压缩后的字节数组。
     *
     * @param map 存储字符对应的Huffman编码表，键为字符的ASCII码值，值为该字符对应的Huffman编码
     * @param str 需要压缩的字符串
     * @return 返回压缩后的字节数组
     */
    private static byte[] zipCode(Map<String, String> map, byte[] bytes) {
        // 将字符串转为字节数组
        // 用于存储压缩后的二进制字符串
        StringBuilder stringBuilder = new StringBuilder();

        // 遍历字节数组，根据Huffman编码表将每个字节进行压缩
        for (byte aByte : bytes) {
            stringBuilder.append(map.get(String.valueOf(aByte)));
        }



        // 计算压缩后的字节数
        int afterCode = (stringBuilder.length() + 7) / 8;
        int le = stringBuilder.length()%8;

        // 创建一个新的字节数组，准备传递新编码的内容
        int count = 0;
        byte[] bytes1 = new byte[afterCode];
        for (int i = 0; i < stringBuilder.length(); i = i + 8) {
            // 对每8位二进制数进行转换为byte类型
            String substring;
            if (i + 8 > stringBuilder.length()) {
                substring = stringBuilder.substring(i);
            } else {
                substring = stringBuilder.substring(i, i + 8);
            }
            bytes1[count] = (byte) Integer.parseInt(substring, 2);
            count++;
        }

        // 打印压缩前后的字节数
        System.out.printf("压缩前是%d字节,压缩后是%d字节", bytes.length, bytes1.length);
        // 返回压缩后的字节数组
        return bytes1;
    }


    /**
     * 霍夫曼解码字符
     *
     * 对huffman 解码
     *
     * @param b    需要解码的字符
     * @param flag 是否为负数
     * @return {@link String}
     */
    private static String decodeHuffmanBytes(byte b, boolean flag) {
        int temp = b;
        //此时这个字符为 负数 需要补码
        if (flag) {
            temp = temp | 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }


    }

    /**
     * referce 解码
     *
     * @param map   传入的编码表
     * @param bytes 需要解码的huffman表
     * @return {@link byte[]} 返回的是一个解码完成的byte
     */
    private static byte[] reference(Map<String,String> map,byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<bytes.length;i++) {
            boolean flag = (i==bytes.length-1);
            stringBuilder.append(decodeHuffmanBytes(bytes[i],!flag));
        }




        //对编码表进行取反,使用的是新创建一个map的方法
        HashMap<String, String> newMap = new HashMap<>();
        map.forEach((key,value)->{
            newMap.put(value,key);

        });

        //开始根据编码表反向查找文本内容
        List<Byte> bytes2 = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            boolean flag = true;
            int count =0;
            while (flag) {

                String st = stringBuilder.substring(i, i+count);
                String s1 = newMap.get(st);
                if (s1 == null){
                    count++;
                }else {
                    flag = false;
                    i = i+count;
                    count = 0;

                    bytes2.add(Byte.valueOf(s1));
                }

            }
        }
        byte[] bytes1 = new byte[bytes2.size()];
        int i= 0;
        for (Byte aByte : bytes2) {
            bytes1[i] = bytes2.get(i);
            i++;
        }

        return bytes1;
    }


//    //可能为错
//    private static byte[] reference(Map<String,String> map, byte[] bytes){
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i=0;i<bytes.length;i++) {
//            boolean flag = (i==bytes.length-1);
//            stringBuilder.append(decodeHuffmanBytes(bytes[i],!flag));
//        }
//
//        // 对编码表进行取反,使用的是新创建一个map的方法
//        Map<String, String> newMap = new HashMap<>(); // 改为用接口类型声明，便于以后切换实现类
//        map.forEach((key,value)->{
//            newMap.put(value,key);
//        });
//
//        // 开始根据编码表反向查找文本内容
//        List<Byte> bytes2 = new ArrayList<>();
//        for (int i=0;i<stringBuilder.length();){
//            boolean flag = true;
//            int count =0;
//            while (flag && i+count <= stringBuilder.length()) { // 添加i+count <= stringBuilder.length() 的判断，避免越界
//                String st = stringBuilder.substring(i, i+count);
//                String s1 = newMap.get(st);
//                if (s1 == null){
//                    count++;
//                }else {
//                    flag = false;
//                    i = i+count;
//                    count = 0;
//                    bytes2.add(Byte.valueOf(s1)); // 由于已经获取了s1，可以直接将其转为byte，避免不必要的自动装箱操作
//                }
//
//            }
//        }
//        byte[] bytes1 = new byte[bytes2.size()];
//        for (int i = 0; i < bytes2.size(); i++) { // 修改遍历方式
//            bytes1[i] = bytes2.get(i);
//        }
//
//        return bytes1;
//    }


}


/**
 * 节点
 *
 * @author hou
 * @date 2023/03/02 17:27
 */
class Node1 implements Comparable<Node1> {
    Node1 left;
    Node1 right;
    int weidth;
    Byte date;

    public Node1(int weidth, Byte date) {
        this.weidth = weidth;
        this.date = date;
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node1{" +
                "weidth=" + weidth +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(Node1 o) {
        return this.weidth - o.weidth;
    }
}
