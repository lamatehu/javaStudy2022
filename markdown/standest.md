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

# 3.文件传输流

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

### 4.1.2 实现多线程的三种方法 Thread Runnable Callable

run() 方法会和平时创建对象的方法一样直接运行

start() 方法会创建一个线程

```java
    public static void main(String[] args) {
        demoThread d1 = new demoThread();
        demoThread d2 = new demoThread();
        d1.run();
        d1.start();
        d2.run();
        d2.start();
    }
```

第二种

```java
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<=100;i++){
            System.out.println(i);
        }
    }
}

        RunnableDemo runnableDemo = new 				    RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
        Thread thread1 = new Thread(runnableDemo);
        thread1.start();
```

第三种 callable

```java
public class callableDemo implements Callable {

    @Override
    public String call() throws Exception {
        for (int i =0;i<=100;i++){
            System.out.println(i + "这是callable");
        }
        return "aaa";
    }
}

    public static void main(String[] args) throws 	ExecutionException, InterruptedException {
     callableDemo callableDemo = new callableDemo();    FutureTask<String> ft = new FutureTask<String>(callableDemo);
        Thread tr = new Thread(ft);
        tr.start();
        String s = ft.get();
        System.out.println(s);

    }
```

![image-20220906183318947](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209061833074.png)

### 4.1.3 线程的一些方法

| 方法名称               | 方法作用                         |
| ---------------------- | -------------------------------- |
| getName()              | 获取线程的名称                   |
| setName()              | 设置线程的名称                   |
| static currentTHread() | 返回当前正在执行的线程对象的引用 |
| sleep() ms             | 让进程休眠多少毫秒               |



### 4.1.4 线程调度和守护

**线程调度**

![image-20220906190742409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209061907476.png)

**守护线程**

当普通线程执行完之后，那么守护进程就没有必要存在了

setDaemon（boolean on） 守护线程

4.1.5 线程的安全

> 如果说，几个线程都在卖票，那么由于cpu资源随机分配到线程处，就会出现在进入线程时还有票，但出了线程就票的现像。

![image-20220907050626850](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209070506986.png)

这个方法不仅可以作用到代码块上，还可以作用到方法上。如这样

```java
    public static synchronized void ss(){
        System.out.println();
    }
```



**新方法Lock锁**

```java
    private static ReentrantLock  locks = new ReentrantLock();
```

**死锁**

指两个锁互相嵌套，而导致线程运行不下去的情况

![image-20220907181825671](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209071818161.png)



### 4.1.5 生产者和消费者



![image-20220907182655070](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209071826147.png)

```java
// 数据类
public class table {
    public static final Object locks = new Object();
    public static boolean flag = true;
    public static int cake = 10;
}
```

```java
// 厨师类
public class cook extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (table.locks){
                if (table.cake == 0){
                    break;
                }else {
                    if (!table.flag){
                        System.out.println("大厨正在制作蛋糕");
                        table.cake --;
                        table.flag = true;
                        table.locks.notifyAll();
                    }else{
                        try {
                            table.locks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
```

```java
//食客类
public class eat extends Thread{
    @Override
    public void run() {
        while (true){
            synchronized (table.locks){
                if (table.cake== 0){
                    break;
                }else {
                    if (table.flag){
                        //现在桌子上有就开吃
                        System.out.println("客人正在吃汉堡");
                        table.flag = false;
                        table.locks.notifyAll();
                    }else{
                        try {
                            table.locks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
```

---



## 4.2 线程池（9.8）

### 4.2.1 线程池

**一条线程的状态**

![image-20220908025658392](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209080256514.png)



| 方法名                  | 作用                                               |
| ----------------------- | -------------------------------------------------- |
| ExecutorsServkce()      | 创建一个线程池                                     |
| newFixedThreadPool(int) | 创建一个定义有多少个线程的线程池                   |
| submit()                | 自动帮我们创建对象，任务执行完毕，会把线程还给池子 |
| shutdown()              | 关闭线程池                                         |

```java
    private static void standest() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            System.out.println("钓鱼时间到了");
        });
        Thread.sleep(2000);
        executorService.submit(()->{
            System.out.println("人在塔在");
        });
        executorService.shutdown();
    }

    //这个方法定义了一个线程池，submit方法是当想要使用一个线程的时候，系统自动生成一个线程，用完之后自动的回收
    private static void easyPool() {
        //这里没有定义最多可以有多少个线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(()->{
            System.out.println(Thread.currentThread() + "线程正在行动");
                });
        executorService.submit(()->{
           System.out.println(Thread.currentThread() + "正在行动");
        });
        executorService.shutdown();
        System.out.println("线程结束");
    }
```



---

### 4.2.2 自定义创建线程池

![image-20220908033827210](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209080338308.png)

```java
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, //固定线程数
                3, //最大线程数
                8,      // 空闲线程等待时间数
                TimeUnit.SECONDS,   //  等待时间单位
                new ArrayBlockingQueue<>(5),    //等待队列长度
                Executors.defaultThreadFactory(),       //线程池创建方式 （默认）
                new ThreadPoolExecutor.AbortPolicy());  //线程拒绝策略

    }
```

```java
       //使用方式
		threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("哈哈啊");
            }
        });
        threadPoolExecutor.shutdown();
```



**什么时候拒绝**

![image-20220908041651333](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209080416426.png)

**任务拒绝策略**

![image-20220908042100872](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209080421950.png)

## 4.3 网络编程



### 4.3.1 网络编程三要素

#### ip 地址

ip是分配给上网折别的数字标签，常见的IP分类为 “ipv4”和"ipv6"

ipv4 32位 8字节为1组 一共4组 点分2进制

ipv6 128位 16字节为1组 一共8组 冒分16进制

**命令**

ipconfig

ping

- 端口
  - 唯一标识
- 协议
  - udp
  - tcp

Inetaddress	InetAddress.getByName

address.getHostName()

address.getHostAddress



```java
    public static void main(String[] args) throws UnknownHostException {
        //获取ip地址和 网络主机名称
        InetAddress address = InetAddress.getByName("DESKTOP-5MKDOL2");
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println("hostAddress :" + hostAddress +"\n" +
                "hostName :" + hostName
        );
    }
```

#### 端口号 （9.10日）

应用程序在圣杯中的唯一标识

端口号0-65535	一个端口只能被一个程序所使用

#### 协议

连接和通行的规则被称为网络通信协议

- udp
  - 面向无连接通信协议	速度快 容易导致数据丢失
- tcp
  - 面向连接的通信协议
  - 速度慢，没有大小限制，数据安全

 **Java主要是在应用层面通信的**

### 4.3.2 udp 传输数据

#### udp发送数据

![image-20220910045125654](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209100451807.png)



```java
    public static void main(String[] args) throws IOException {
        //udp 发送数据
        //1. 创建连接
        DatagramSocket datagramSocket = new DatagramSocket();
        //2.设置要发送的数据
        String msg = "老师您号，我是哈哈啊哈";
        byte[] bytes = msg.getBytes();
        InetAddress address =InetAddress.getByName("127.0.0.1");
        //3. 配置包裹
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, address, 8899);
        //4. 发送包裹
        datagramSocket.send(datagramPacket);
        //5. 关闭连接
        datagramSocket.close()
    }
	
```



#### udp 接受数据

![image-20220910050918407](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209100509495.png)

```java
    public static void main(String[] args) throws IOException {
        // 设定监听端口
        DatagramSocket datagramSocket = new DatagramSocket(65440);
        byte[] bytes = new byte[1024];
        // 配置接受的大小
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //开始接受数据
        datagramSocket.receive(datagramPacket);
        //获取数据长度 和数据
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        //数据转换
        System.out.println(new String(data,0,length));
        //关闭连接
        datagramSocket.close();
    }
```



练习，发送结收

```java
        //配置发送窗口
        DatagramSocket datagramSocket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        //配置要发送的数据


        while (true) {
            System.out.println("请输入你要发送的数据：");
            String next = sc.next();

            byte[] bytes1 = next.getBytes();

            InetAddress byName = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length, byName, 63001);
            datagramSocket.send(datagramPacket);

            if (next.equals("886")) {
                System.out.println("结束发送");
                break;
            }

        }
        datagramSocket.close();
    }
```

接收

```java
public static void main(String[] args) throws IOException {
    //接受端是个死循环啊
    // 先设置传输接口
    DatagramSocket datagramSocket = new DatagramSocket(63001);
    //再配置接受数据包果
    while (true) {
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        int length = datagramPacket.getLength();
        String s = new String(data, 0, length);
        System.out.println(new String(data,0,length));
        if (s.equals("886")){
            datagramSocket.close();
            System.out.println("通话结束");
            break;
        }

    }

}
```



### 4.3.3 udp的三种通讯方式

- 单播 一对一
- 组播  一对多
- 广播  一个对所有

**组播的实现**

组播地址： 224.0.0.0 - 239.255.255.255

其中224.0.0.0 - 224.0.0.255 为预留的组播地址

![image-20220910061941893](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209100619014.png)

```java
        MulticastSocket multicastSocket = new MulticastSocket();
        InetAddress byName = InetAddress.getByName("224.0.0.21");
        String s = "哈哈啊哈";
        DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(), s.getBytes().length, byName, 60002);
        multicastSocket.send(datagramPacket);
        multicastSocket.close();
```

接收

```java
        MulticastSocket multicastSocket = new MulticastSocket(60002);
        multicastSocket.joinGroup(InetAddress.getByName("224.0.0.21"));
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        multicastSocket.receive(datagramPacket);
        byte[] data = datagramPacket.getData();
        System.out.println(new String(data));
```

### 4.3.4 Tcp 通信原理（9.11）

![image-20220910064536958](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209100645049.png)

#### 三次握手

![image-20220911052327519](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209110523609.png)

#### 四次挥手

![image-20220911052531177](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209110525271.png)





### 4.3.5 Tcp服务端与客户端的发送与接收

![image-20220911043148562](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209110431643.png)

![image-20220911052034254](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209110520358.png)

```java
//客户端        
Socket socket = new Socket("127.0.0.1", 54000);
        OutputStream outputStream = socket.getOutputStream();
        String aa = "aaa";
        outputStream.write(aa.getBytes());
        outputStream.close();
        socket.close();

```

```java
//服务端
        ServerSocket serverSocket = new ServerSocket(54000);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int b;

        while((b = inputStream.read()) !=-1){
            System.out.print((char) b);
        }
        inputStream.close();
        serverSocket.close();
```

### 4.3.6 文件传输和中文传输

文件传输有几个步骤

- 首先先在客户端拿到文件的数据
- 把这个数据发送到服务器上
- 接受是否成功的消息

服务端

- 接受客户端的数据
- 把客户端的数据存入到本地文件中
- 发送消息通知客户端

```java
        //	文件传输客户端
		FileInputStream fileInputStream = new FileInputStream("study/img/IMG_20200530_152020.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        Socket socket = new Socket("127.0.0.1", 58888);
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int b;
        while ((b = bufferedInputStream.read()) != -1){
            bufferedOutputStream.write(b);
        }
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String aa;
        while ((aa = bufferedReader.readLine())!=null){
            System.out.println(aa);
        }
        socket.shutdownInput();
		socket.close();

```

```java
//文件传输服务端
        ServerSocket serverSocket = new ServerSocket(58888);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);


        FileOutputStream fileOutputStream = new FileOutputStream("study/copy/1.jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fileOutputStream);
        int aa;
        while ((aa = bufferedInputStream.read()) != -1){
            bos.write(aa);
        }
        accept.shutdownInput();

        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("已完成".getBytes());
        accept.shutdownOutput();
		socket.close();
```

### 4.3.7 Tcp服务的优化 （9.12）

1. 第一个弊端就是服务器只能响应一次，这个时候用while循环既可以一直接收文件
2. 第二个弊端是每次上传的文件都会把上一个文件覆盖掉，这个时候使用随机生成的文件名（**uuid**）
3. 第三个弊端是每次只能连接一个客户端，无法同时处理一个客户端。同时处理多个客户端 用多线程
4. 第四个弊端是使用多线程会让资源消耗太多，这个时候用一个线程池代替 **ThreadPool**

#### UUID

```java
//获取一个uuid
String s = UUID.randomUUID().toString().replace("-","");
```

#### 多线程

```java
//main
public class serverDemo {
    public static void main(String[] args) throws IOException {
        // 创建连接
        ServerSocket ss = new ServerSocket(54200);
        while (true) {
            Socket accept = ss.accept();
            ThreadSocket threadSocket = new ThreadSocket(accept);
            new Thread(threadSocket).start();
        }
//        ss.close();
    }
```



```java
//server Thread
public class ThreadSocket implements Runnable {
    private final Socket accept;

    public ThreadSocket(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;

        try {
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());

            //自动将文件重命名 uuid
            String s = UUID.randomUUID().toString().replace("-", "");

             bos = new BufferedOutputStream(new FileOutputStream("study/copy/" + s + ".jpg"));


            int aa;
            while ((aa = bis.read()) != -1) {
                bos.write(aa);
            }
            //传输成功候关闭连接
            accept.shutdownInput();


            //传输接受成功的信息
            System.out.println("开始传输信息");
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("传输成功".getBytes());
            accept.shutdownOutput();

            System.out.println("传输完成");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //关闭连接
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
```





#### 线程池

其他代码上同

```java
    public static void main(String[] args) throws IOException {

        //创建线程池
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, //核心线程
                5, //最大线程
                1, //线程存在时间
                TimeUnit.MINUTES, //线程时间单位
                new ArrayBlockingQueue<>(5),//阻塞队列
                Executors.defaultThreadFactory(),   //创建线程方式
                new ThreadPoolExecutor.AbortPolicy());  //任务拒绝策略
        // 创建连接
        ServerSocket ss = new ServerSocket(54200);
        while (true) {
            Socket accept = ss.accept();
            //使用线程池
            tpe.submit(new ThreadSocket(accept));
        }
//        ss.close();



    }
```





---

## 4.4 日志

### 4.4.1  什么是日志

#### 输出语句的弊端

![image-20220912065057207](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209120651392.png)

#### 日志与输出语句的区别

![image-20220912065153522](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209120651658.png)

#### 日志的优点

![image-20220912065350662](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209120653751.png)



#### 日志的两个体系结构

![image-20220912065600314](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209120656443.png)

---

### 4.4.2 LogBack 介绍与使用

- logback-core: 该模块为其他两个模块提供基础的代码，必须有
- logback-classic: 完整实现了slf4j API模块。
- logback-access 模块与Tomcat 和 Jetty 等 Servlet容器集成，提供HTTP 访问日志的功能

#### Logback 快速入门

![image-20220912174411935](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209121744060.png)

```java
public class Demo1 {
    //导入logback
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo1.class);
    public static void main(String[] args) {
        System.out.println("aaa");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        LOGGER.info("用户输入的是"+next);

    }
}

```

```java
//logback配置文件 可能有问题
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="false">
    <!--定义日志文件的存储地址 勿在 LogBack 的配置中使用相对路径-->
    <property name="LOG_HOME" value="/home" />
    <!-- 控制台输出 -->
    <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
        <target>System.out</target>
        <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
            <!--格式化输出：%d表示日期，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符-->
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>
        </encoder>
    </appender>
    <!-- 按照每天生成日志文件 -->
    <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">
        <encoder>
            <pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} -%msg%n</pattern>
            <charset>utf-8</charset>
        </encoder>
        <file>D:/limenyUan/haha.log</file>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!--日志文件输出的文件名-->
            <FileNamePattern>D:/limenyUan/TestWeb.log.%d{yyyy-MM-dd}.log</FileNamePattern>
            <MaxFileSize>1MB</MaxFileSize>
        </rollingPolicy>
        <!--日志文件最大的大小-->
    </appender>

    <!-- 日志输出级别 -->
    <root level="INFO">
        <appender-ref ref="CONSOLE" />
        <appender-ref ref="FILE" />
    </root>
</configuration>
```



## 4.5 . 枚举

####  定义一个枚举类（enum）



#### 枚举的特点

![image-20220912180630869](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209121806971.png)

```java
public enum sesson {
    Spring("春"){
        @Override
        public void show() {
            System.out.println(Spring.name+"你好春天");
        }
    },Winter("冬"){
        @Override
        public void show() {
            System.out.println(Winter.name+"你好冬天");
        }
    },Autumn("秋"){
        @Override
        public void show() {
            System.out.println(Autumn.name+"你好秋");
        }
    },Summer("夏"){
        @Override
        public void show() {
            System.out.println(Summer.name+"你好夏天");
        }
    };
    private sesson(){

    }
    private sesson(String name){
        name = this.name();
    }
    private String name;

    public abstract void show();
}
```

#### 枚举的方法

![](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209121834418.png)

```java
        //name 打印名称
        System.out.println(sesson.Summer.name());
        //获取枚举索引
        int ordinal = sesson.Winter.ordinal();
        //比较两者的索引差值
        int i = sesson.Autumn.compareTo(sesson.Summer);
        //打印
        String s = sesson.Autumn.toString();
        System.out.println(s);
        //通过类加载的方式获得对象
        sesson autume = Enum.valueOf(sesson.class, "Autumn");
        System.out.println(autume.name());
        //获取枚举类的所有对象
        sesson[] values = sesson.values();
        for (int i1 = 0; i1 < values.length; i1++) {
            System.out.println(values[i1].name());
        }
    }
```

----

## 

# 5.类加载器（9.13）

## 5.1 类加载器

![image-20220913045727053](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130457172.png)

把class文件加载到内存中

### 类加载的时机

1. 创建类的实例
2. 调用类的类方法
3. 访问类或者接口的类变量，或者为该类的变量赋值
4. 使用放射或者强制创建某个类或者对应的java.lang.Class对象
5. 初始化某个类的子类
6. 直接使用java.exe 运行某个子类

### 类加载的过程

![image-20220913050509498](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130505612.png)

![image-20220913050932496](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130509622.png)

![image-20220913051028618](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130510734.png)

### 类加载器的分类

![image-20220913051644302](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130516438.png)

### 双亲委派模型

所有的加载请求都会到启动类加载器中

![image-20220913052046396](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130520504.png)

```java
    public static void main(String[] args) {
        //系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //平台类加载器
        ClassLoader parent = systemClassLoader.getParent();
        //启动类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(parent1);
```

### 类加载的重要方法

![image-20220913060329081](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130603186.png)

```java
        //通过类加载器来读取properties里的东西
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        InputStream resourceAsStream = systemClassLoader.getResourceAsStream("prop.properties");
        
        Properties ppt = new Properties();
        ppt.load(resourceAsStream);
        System.out.println(ppt);
```

---

## 5.2 反射

### 反射概述

![image-20220913062600357](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130626496.png)

可以无视修饰修饰符，获取类中的所有芳芳

先获取到文件中的信息，动态创建对象和调用方法

### 获取class对象

![image-20220913063620294](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130636411.png)

```java
        //第一个通过forname加载
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
        System.out.println(aClass);
        //第二种通过getclass类加载
        Student student = new Student();
        Class aClass1 = student.getClass();
        System.out.println(aClass1);
        //第三种通过类名加class来加载
        Class<Student> studentClass = Student.class;
        
```

### 获取构造方法

```java
    Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
    //获取无参构造
    Constructor<?> constructor = aClass.getConstructor();
    System.out.println(constructor);
    //获取有参构造
    Constructor<?> constructor1 = aClass.getConstructor(String.class, String.class, String.class, String.class);
    System.out.println(constructor1);
    //获取构造数组
    Constructor<?>[] constructors = aClass.getConstructors();
    for (int i = 0; i < constructors.length; i++) {
        System.out.println(constructors[i]);
    }
    //可以获取所有构造，但选一个
    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
    System.out.println(declaredConstructor);
    //获取所有构造 打包成数组
    Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
    System.out.println(declaredConstructors);
}
```



### 创建对象

![image-20220913073038911](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130730057.png)

```java
//        获取类对象
        Class<?> aClass = Class.forName("com.hou.classLoaderDemo.Student");
//        //获取类
        Constructor<?> constructor = aClass.getConstructor(String.class, String.class, String.class, String.class);
        Student o = (Student)constructor.newInstance("zhangsan", "18", "male", "88");
        System.out.println(o);
        //创建私有构造
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Student o1 = (Student)declaredConstructor.newInstance("zhangsan");
        System.out.println(o1);

```

![image-20220913075805224](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130758347.png)

### 获取filed对象

![image-20220913081131080](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130811225.png)

```java
        Class<Student> studentClass = Student.class;
        Field name = studentClass.getField("name");
        System.out.println(name);

        //创建对象赋值
        Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, String.class, String.class);
        Student student = constructor.newInstance("zhangsan", "18", "male", "88");
        //把对象的值修改
        name.set(student,"sanfan");
        //获取student中这个对象的值
        Object o = name.get(student);
        System.out.println(o);
        System.out.println(student.toString());
```

### 获取method方法

![image-20220913082345040](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130823180.png)

![image-20220913082927115](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209130829234.png)

```java
//获取类
Class<Student> studentClass = Student.class;
//获取方法
Method eat = studentClass.getMethod("eat");
//因为要实例，所以创建一个
Constructor<Student> constructor = studentClass.getConstructor(String.class, String.class, String.class, String.class);
Student student = constructor.newInstance("zhangsan", "18", "male", "88");
//运行这个方法，并有一个返回值
Object invoke = eat.invoke(student);
System.out.println(invoke);
```

---

# 6.xml(9.15)

## 6.1 xml概述

![image-20220915051030760](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150510026.png)

**XML 文件是由许多标签组成的，而标签名是可以自定义的。**

作用：

- 用于进行存储数据和传输数据
- 作为软件的配置文件

## 6.2 xml的规则

### 标签规则

![image-20220915051604420](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150516522.png)

### 语法规则

![image-20220915051849829](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150518918.png)

```java
<?xml version="1.0" encoding = "utf-8" ?>
<!--这是注释-->
<Students>
    <Student id="1">
        <name>"张三"</name>
        <age>17</age>
        <message>&gt;&lt;</message>
    </Student>
    <Student id="1">
        <name>"张三"</name>
        <age>17</age>
        <message><![CDATA[你好吗，王多鱼]]></message>
    </Student>
</Students>
```

## 6.3 xml解析

![image-20220915053621857](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150536933.png)

![image-20220915053848409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150538524.png)

### 解析XML的工具

![image-20220915054231439](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150542519.png)

```html
https://dom4j.github.io/
下载到本地导入jar包
```

```java
    public static void main(String[] args) throws DocumentException {
        //利用xml读取数据
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("logback/src/com/hou/xml/Students.xml");
        Element rootElement = read.getRootElement();
        List<Element> studentsElement = rootElement.elements("Student");

        //创建学生数组
        ArrayList<Student> StudentList = new ArrayList<>();
        for(Element element : studentsElement){
            Attribute id = element.attribute("id");
            //获取学生id
            String idData = id.getStringValue();
            //获取名字年龄信息
            Element name = element.element("name");
            String nameData = name.getText();
            Element age = element.element("age");
            String ageData = age.getText();
            Element message = element.element("message");
            String messageData = message.getText();
            System.out.println(nameData+ " "+idData.toString() + " " + ageData +" "+ messageData);
            // 信息获取完毕 创建对象后添加到数组中
            Student student1 = new Student(Integer.parseInt(idData),Integer.parseInt(ageData),nameData,messageData);
            StudentList.add(student1);
        }
        //最后输出两个对象
        System.out.println(StudentList.toString());
    }
}

```

### XML约束

用来限定xml文件中可使用的标签和属性

**两种约束**

- DTD 约束

![image-20220915064948570](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150649695.png)

 ```java
 <!ELEMENT persons (person)>
 <!ELEMENT person (name,age)>
 <!ELEMENT name (#PCDATA)>
 <!ELEMENT age (#PCDATA)>
 ```

**引入dtd**

```dtd
<!DOCTYPE persons SYSTEM 'xml.dtd'>
```

**引入DTD的三种方式**

- 引入本地DTD
- 在xml文件内部引入
- 引入网络dtd

![image-20220915070524672](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150705772.png)

DTD 语法规则

![image-20220915070736105](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209150707240.png)

![image-20220916035255705](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160353022.png)

### schema 约束(9.16)

1. schema约束文件也是一个xml文件，符合xml的语法，这个文件的后缀名.xsd

2. 一个xml中可以引用多个schema约束文件，多个schema使用名称空间区分(名称空间类似于java包名)
3. dtd里面元素类型的取值比较单一常见的是PCDATA类型，但是在schema里面可以指出很多个数据类型
4. schema语法更加复杂

![image-20220916040321423](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160403542.png)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<schema xmlns="http://www.w3.org/2001/XMLSchema"
targetNamespace="http://www.itheima.com"
        elementFormDefault="qualified"
>
    <!--定义persons复杂元素-->
    <element name="persons">
        <!--定义复杂元素-->
        <complexType>
            <sequence>
                <element name="person">
                    <complexType>
                        <sequence>
                            <!--定义简单元素-->
                            <element name="name" type="string"/>
                            <element name="age" type="string"/>
                        </sequence>
                    </complexType>
                </element>

            </sequence>
        </complexType>
    </element>

</schema>
```

#### 引入方法

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<persons
    xmlns:xls = "http://www.w3.org/2001/XMLSchema-instance"
    xmlns = "http://www.itheima.com">
    <!--引用约束文件的标签-->
    <person>
        <name>aa</name>
        <age>19</age>
    </person>

</persons>
```

**Schema定义属性**

```xml
    <!--定义persons复杂元素-->
    <element name="persons">
        <!--定义复杂元素-->
        <complexType>
            <sequence>
                <element name="person">
                    <complexType>
                        <sequence>
                            <!--定义简单元素-->
                            <element name="name" type="string"/>
                            <element name="age" type="string"/>
                        </sequence>
                        <!--定义属性-->
                        <attribute name="id" type="string" use="required"/>
                    </complexType>
                </element>
            </sequence>
        </complexType>
    </element>
```



----

# 7.注解

## 注解的作用

![image-20220916042457685](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160424762.png)



## 元注解

写在注解上面的注解就是元注解

![image-20220916064142629](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160641840.png)

```java
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE}) //注解能在哪里使用
@Retention(RetentionPolicy.RUNTIME) // 可以存在到运行阶段
@Inherited //指定这个注解可以被继承
public @interface anno2 {
}

```

## **单元测试**

![image-20220916065401777](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160654871.png)

### Junit 

是一个源代代码的测试工具

![image-20220916065601264](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160656328.png)

运行良好是绿色，运行失败是红色

### 使用基本的流程

导入Junit包 4.10之后需要导入

- [`junit.jar`](https://search.maven.org/search?q=g:junit AND a:junit)
- [`hamcrest-core.jar`](https://search.maven.org/artifact/org.hamcrest/hamcrest-core/1.3/jar)

![image-20220916071432888](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209160714974.png)
