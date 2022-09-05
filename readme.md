# 开工
## 8.16 导入前两天学的12.5 学生管理系统的课程
## 8.20 .3 用arraylist 重新修改了 dao层逻辑

## 8.20 .4 接口修改了 BaseStundenntDao 从抽象类变成了接口

## 8.24 .6 lanbda表达式
8.28
### 匿名内部类的调用及lambda 表达式的调用

```code

public class test4 {
    public static void main(String[] args) {
        useTwoNumberAdd(new TwoNumberAdd() {
            @Override
            public int addTwo(int a, int b) {
                return a+b;
            }
        });
        useTwoNumberAdd((int a,int b)->{return a+b;});
    }
    public static void useTwoNumberAdd(TwoNumberAdd twoNumberAdd){
        int result = twoNumberAdd.addTwo(10,20);
        System.out.println(result);
    }
}

interface TwoNumberAdd{
    int addTwo(int a,int b);
}


```

##  3.1 stream 流

### 8.30

### 3.1.5
limit 截取几个
skip 跳过
concat 合并两个流
distinct 去除流中的两个元素

### 3.1.6 test6EndStream
3:56
终结里面的操作
1. foreach 方法
2. count 方法
```java
long count = list.Stream().count();
list.Stream().foreach(s->System.out.println(s)

```

### 3.1.7 Stream 收集结果
4:09
stream 流不能直接修改数据源里面的数据

### 3.1.8 Stream 流怎么保存修改后的数据
4.15
- toList 数组
- toSet
- toMap


### 3.2.1 文件

17：03

1. CreateNewFile() 创建一个文件 不管有没有后缀
2. mkdir() 单级文件夹
3. mkdirs() 单&多级文件夹 只能创建文件夹

### 3.2.2 文件删除

1. delete() 删除 删除时不走回收站 可删文件夹和文件 只能删除空文件夹

### 3.2.3 判断
17:26
- isFile() 是否为一个文件
- isDirectory() 是否为一个文件夹
- isexist() 文件是否存在
- getname() 调用的时候为文件 文件名和后缀名，如果调用的是文件夹，则获取的是文件夹的名字

### 3.2.4 File 类高级获取方式
17:33
//进入文件夹，获取这个文件夹的所有的文件和文件夹的File对象，并把这些File对象都放到一个数组中返回

listFiles()
不存在返回null，文件返回null，空文件夹返回 0，

### 3.2.5 File 测试3  统计文件下的文件类型的数量

/study/com/hou/fileDemo/test5DirCount

### 3.3.1
8.31 3:44

- 字符流 纯文本文件 记事本能打的开的
- 字节流 打不开的，比如音乐，图片 就不行

### 3.3.2 字节流写数据
- 文件存在 则会被覆盖
- 文件不存在，则会被覆盖
- write() 方法 传入的整数是写一个对应的字符进去

```java
// 先写输出流
// 往里写数据
files.write()
// 最后关闭
fileS.close();


```

- 一次写一个
- 一次写多个 (byte[] b)
- 一次写多个，但决定写几个 (byte[] b,int off,int len)


### try catch 捕获异常

finally 里面把close 最后关闭

### 3.2.3

字节流读数据
FileInputStream fis = new FileInputStream("d:\\cc.txt");
fis.read();
fis.close();


### 3.3.1 字节缓冲流

字节缓冲流只提供了一个缓冲区，不能直接操作数据
- bufferOutputStream 字节输出缓冲流
- buffereadInputStream 字节输入缓冲流
```java
            FileInputStream ris = new FileInputStream("D:\\limenyUan\\java\\01-案例驱动教学模式介绍【海量 资源：666java.com】.flv");
            FileOutputStream ros = new FileOutputStream("D:\\limenyUan\\java\\012.flv");
            BufferedInputStream bis = new BufferedInputStream(ris);
            int b;
            while ((b= bis.read()) != -1){
                ros.write(b);
            }
```

字节流有两种方式，一个是单个字符传输，一个是数组传输，当使用缓冲流时，用数组传输的时候，速度明显比单个字符传输的速度更快。
字节读取->字节读取缓冲流->字节写入缓冲流->字节写入流


### 3.3.2 字符流

为什么要使用字符流，因为使用字节流可能会出现文字乱码，
计算机传输的数据都是以编码表的形式而存在的。ascill码 平台默认的字符集

- 为什么字节流会乱码？
因为字节流每次只读一个字节，所以会导致乱码。

字符流来读取中文
1. 想要进行卡贝，一律使用字节流或者字节缓冲流。
2. 想要把文本文件中的数据读到内存中，请使用字符输入流。
    想要把内存中的数据写道文本文件中，请使用字符输出流
3. GBK码表中一个中文两个字节，utf-8 编码格式一个中文3个字节


### 3.4.1 对象操作流

可以把对象以字节的形式写到本地文件中

- 对象操作输入流   将文件中的对象读取到内存中   ObjectInputStream(new FileInputStream) readObject
- 对象操作输出流   将对象写到文件中    ObjectOutputStream(new FileOutputStream) writeObject

如果想要一个类的对象能被序列化，这个类必须要实现一个Serialiazable接口
Serilizable 接口的意义 标志性接口，没有任何的抽象方法，只要实现了这个接口，就说明可以被序列化

### 3.4.2 对象输入流

可以把文件的对象读到内存中
seriaVersionUID 序列号
如果我们自己没有定义，那么虚拟机会根据类中的信息自动计算出一个序列号，
```java
    private static final long seriaVersionUID
```
transient 关键字修饰词 变量被修饰化后，不会被序列化显示到文件中

### 3.5.1 Properties 对象

9.6 3:00

Properties 是一个map集合

Properties 中有和io相关的方法

![](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209060305904.png)

**作为map集合来使用**

```java
        //关于properties用于map的方法
        Properties pron = new Properties();

        // 写入
        pron.put("学生","老师");
        pron.put("工人","领导");
        //删除
        pron.remove("工人");
        //修改 使用put方法
        pron.put("学生","大学生");
        //查询
        pron.get("学生");

        // 两种遍历方式
        Set<Object> objects = pron.keySet();
        for (Object key : objects) {
            System.out.println(key);
            System.out.println(pron.get(key));
        }
        // 获取 键值对

        Set<Map.Entry<Object, Object>> entries = pron.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object value = entry.getValue();
            Object key = entry.getKey();
            System.out.println(key +" = "+value);
        }
    }
}
```

### 3.5.2 Properties 对象关于 io的操作

![image-20220906033305789](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209060333875.png)

**存储和读取**

```java
        //先 读取 properties
        Properties pron = new Properties();
        FileReader fr = new FileReader("study/prop.properties");
        pron.load(fr);
        System.out.println(pron);
        fr.close();
        // 再写入

        pron.put("sex","男");
        pron.put("age","18");
        FileWriter fw = new FileWriter("study/prop.properties");
        pron.store(fw,"个人信息");
        fw.close();
```



# 4. 多线程&网络编程&基础加强（9.6）

## 4.1  多线程

### 4.1.1  并发和并行

![image-20220906041945214](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209060419276.png)

![image-20220906042216445](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209060422517.png)