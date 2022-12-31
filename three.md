



# 第三部分JavaWeb



# 课程内容

![image-20220926105402484](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261054675.png)

9.26 mysql

9.27 mysql 约束开始

10.19 重新起航



### Todo

| TaskId | Start time | TO DO | Status | Estimating | end | result |
| ------ | ---------- | ----- | ------ | ---------- | -------- | -------- |
|    1    |     9.26     |   mysql   |  end  | --         |    9.26    | done   |
| 2      | 9.27       | mysql约束   | end    | --         | 10.1 | done   |
| 3      | 10.2       | jdbc driver | active | 10.20      | 10.25 | done |
| 4 | 10.23 | maven | end |            | 10.25 | done |
|        |            |             |        |            |      |        |
|        |            |             |        |            |      |        |

# 暂时存放

![image-20221006000710311](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210060007539.png)

# 1. MYSQL

## 1.1 SQL简介

![image-20220926105554485](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261055561.png)

1. 单行或多行书写，以分号为结尾
2. 没有大小写区分
3. 单行注释为#，多行注释和Java一样 /*  */，行内注释为-- 注释内容

### 数据语言

![image-20220926105850840](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261058911.png)

ddl：操作数据库，表等

dml：对表中的数据进行删改

dql:  对表数据进行查询

dcl:  对数据库进行权限控制

---

## 1.2 DDL

### 操作数据库

```mysql
# 查询数库
show databases;
# 创建数据库
create database dbl;
create database if not exists dbl; -- 判断数据库是否存在之后再船舰
# 删除数据库
drop database db1;
drop database if exists db1; -- 如果数据库存在则删除
# 使用数据库
use  db1;
# 查询当前正在使用的数据库
select DATABASE();
```

![image-20220926110316783](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261103832.png)

### 操作表

```mysql
# 查询表
show tables;
# 查询表的结构
desc students;

# 创建表
create table students(
	id int,
    username varchar(20), -- 创建表 filed type(limit)
    password varchar(32)
)
# 删除表
drop table table1;
drop table if table1 exist; -- 如果表存在的话删除

# 修改表
alter table table1 rename to table2; -- 修改表名
alter table table1 add name varchar(12); -- 添加列
alter table table1 modify name char(12); -- 修改列的数据类型
alter table table1 change name name1 varchar(12); -- 修改列名和他的数据类型
alter table table1 drop name; -- 删除列

```

### 数据类型

| 分类           | 数据类型              | 大小                            | 描述                                                |                                                     |
| -------------- | --------------------- | ------------------------------- | --------------------------------------------------- | --------------------------------------------------- |
| 数值类型       | TINYINT               | 1 byte                          | 小整数值                                            |                                                     |
| SMALLINT       | 2 bytes               | 大整数值                        |                                                     |                                                     |
| MEDIUMINT      | 3 bytes               | 大整数值                        |                                                     |                                                     |
| INT或INTEGER   | 4 bytes               | 大整数值                        | age int                                             |                                                     |
| BIGINT         | 8 bytes               | 极大整数值                      |                                                     |                                                     |
| FLOAT          | 4 bytes               | 单精度浮点数值                  |                                                     |                                                     |
| DOUBLE         | 8 bytes               | 双精度浮点数值                  | score double(总长度,小数点后保留的位数) 0~100 2     | score double(5,2)                                   |
| DECIMAL        |                       | 小数值                          |                                                     |                                                     |
| 日期和时间类型 | DATE                  | 3                               | 日期值                                              | birthday date                                       |
| TIME           | 3                     | 时间值或持续时间                |                                                     |                                                     |
| YEAR           | 1                     | 年份值                          |                                                     |                                                     |
| DATETIME       | 8                     | 混合日期和时间值                |                                                     |                                                     |
| TIMESTAMP      | 4                     | 混合日期和时间值，时间戳        | “张三”                                              | 时间戳                                              |
| 字符串类型     | CHAR                  | 0-255 bytes                     | 定长字符串                                          | name char(10)  10个字符空间   存储的性能高 浪费空间 |
| VARCHAR        | 0-65535 bytes         | 变长字符串                      | name varchar(10)  2个字符空间   存储性能低 节约空间 |                                                     |
| TINYBLOB       | 0-255 bytes           | 不超过 255 个字符的二进制字符串 |                                                     |                                                     |
| TINYTEXT       | 0-255 bytes           | 短文本字符串                    |                                                     |                                                     |
| BLOB           | 0-65 535 bytes        | 二进制形式的长文本数据          |                                                     |                                                     |
| TEXT           | 0-65 535 bytes        | 长文本数据                      |                                                     |                                                     |
| MEDIUMBLOB     | 0-16 777 215 bytes    | 二进制形式的中等长度文本数据    |                                                     |                                                     |
| MEDIUMTEXT     | 0-16 777 215 bytes    | 中等长度文本数据                |                                                     |                                                     |
| LONGBLOB       | 0-4 294 967 295 bytes | 二进制形式的极大文本数据        |                                                     |                                                     |
| LONGTEXT       | 0-4 294 967 295 bytes | 极大文本数据                    |                                                     |                                                     |

#### 什么时候用char和 varchar

char和varchar 一个是定长 一个是变长

char的存储性能高，但浪费空间

varchar的存储性能低，不浪费空间

确定的数据长度，用char

不确定的数据长度 用varchar

#### 一张学生表

![image-20220926112814641](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261128701.png)

```mysql
create table student(
	id int,
    name char(10),
    gender char(1),
    birthday date,
    score double(5,2),
    email varchar(64),
    phone varchar(15),
    status tinyint
);
```

## 1.3 DML

对表进行增删改查的操作

```mysql
# 往表中添加数据
insert into student(id,name) values(1,"张三"); 
# 给所有列添加数据时，可以省略列名
insert into student values(数据1),(数据2);

# 修改表数据
update student set sex = '女' where name = '张三';

# 删除
delete from student where name = '张三';

# 修改和删除的时候，都不加条件，就会都修改或者删除
```

## 1.4 DQL

### 基础查询 & 条件查询

![image-20220926140921590](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261409699.png)

```mysql
-- 练习数据库
-- 删除stu表
drop table if exists stu;


-- 创建stu表
CREATE TABLE stu (
 id int, -- 编号
 name varchar(20), -- 姓名
 age int, -- 年龄
 sex varchar(5), -- 性别
 address varchar(100), -- 地址
 math double(5,2), -- 数学成绩
 english double(5,2), -- 英语成绩
 hire_date date -- 入学时间
);

-- 添加数据
INSERT INTO stu(id,NAME,age,sex,address,math,english,hire_date) 
VALUES 
(1,'马运',55,'男','杭州',66,78,'1995-09-01'),
(2,'马花疼',45,'女','深圳',98,87,'1998-09-01'),
(3,'马斯克',55,'男','香港',56,77,'1999-09-02'),
(4,'柳白',20,'女','湖南',76,65,'1997-09-05'),
(5,'柳青',20,'男','湖南',86,NULL,'1998-09-01'),
(6,'刘德花',57,'男','香港',99,99,'1998-09-01'),
(7,'张学右',22,'女','香港',99,99,'1998-09-01'),
(8,'德玛西亚',18,'男','南京',56,65,'1994-09-02');

```

```mysql
# 基本查询命令

-- 查询name和age两列 查询所有列可以用*
select name,age from stu;

-- 去除重复记录
SELECT DISTINCT address from stu;

-- as 起别名 可省略
select name,math as 学习成绩,english 英语成绩 FROM stu;

-- 查询年龄大于20岁
select * from stu where age >20;
-- 查询年龄小于等于20岁
select * from stu where age<= 20;
-- 查询大于20 且小于 30
select * from stu where age>20 and age<30;

select * from stu where age BETWEEN 20 and 30;

-- 查询入学日期在 1997-1998
select * from stu where hire_date between "1997-01-01" and "1999-01-01";

-- 查询年龄不等于 20 或者不等于21
select * from stu where age !=20 or age =!21;
select * from stu where age in (21,22);

-- 查询英语成绩为null的学员信息
select * from stu where english IS NULL;
select * from stu where english not null; -- 不是null

-- 查询姓马的学员信息(模糊查询)
select * from stu where name like '马%';

-- 查询第二个字是花的
select * from stu where name like '_花%';

-- 查询名字中有德的信息
select * from stu where name like '%德%';

```

![image-20220926143637278](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261436356.png)

### 排序查询 

```mysql
-- 查询学生信息 ，按照年龄升序排列 asc
select * form stu order by age asc;
-- 查询学生信息， 按照数学降序排列
select * from stu order by math desc;
-- 按照数学成绩降序排列，之后再按照升序排列
select * from stu order by math desc,age asc;
```

### 分组查询

#### 聚合函数

![image-20220926144853772](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261448873.png)

```mysql
-- 统计一共有多少个学生
select count(*) from stu; -- count 列名不能为空
-- 查询数学成绩最高分
select max(math) from stu;
-- 查询数学成绩最低分
select sum(math) from stu;
-- 查询数学成绩的平均分
select avg(math) from stu; 
```

#### 分组查询

where 和having

```mysql
-- 查询男同学和女同学各自的数学平均分
select sex ,avg(math) from stu group by sex;
-- 查询男女同学各自的数学平均分和各自的人数
select sex , avg(math), count(*) from stu GROUP BY sex;
-- 查询男女同学各自的数学平均分和各自的人数 数学成绩低于70分不能入组
select sex ,avg(math),count(*) from stu where math>70 GROUP BY sex;
-- 查询男女同学各自的数学平均分和各自的人数 数学成绩低于70分不能入组,分组之后要大于两个
select sex ,avg(math),count(*)>2 from stu where math>70 GROUP BY sex;
```

![image-20220926151027616](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209261510719.png)

### 分页查询

mysql 方言为 limit

```mysql
-- 分页查询(limit)
-- 从0 开始 查询3条数据
select * from stu limit 0,3;
-- 每页显示3条数据，查询第一页数据
select * from stu limit 0,3;
-- 每页显示3条数据，查询第2页数据
select * from stu limit 3,3;
-- 每页显示3条数据，查询第3页数据
select * from stu limit 6,3;

-- 起始索引 (当前页码-1)*每页显示的条数
```



## 1.5  约束（9.27）



### 什么是约束

- 约束时作用于列上的规则，用于限制加入表的数据
- 约束的存在保证了数据库中数据的正确性，有效性和完整性

### 约束的分类

**非空约束： 关键字是** **NOT NULL**

保证列中所有的数据不能有null值。

例如：id列在添加 马花疼 这条数据时就不能添加成功。

**唯一约束：关键字是** **UNIQUE**

保证列中所有数据各不相同。

例如：id列中三条数据的值都是1，这样的数据在添加时是绝对不允许的。

**主键约束： 关键字是** **PRIMARY KEY**

主键是一行数据的唯一标识，要求非空且唯一。一般我们都会给没张表添加一个主键列用来唯一标识数据。

例如：上图表中id就可以作为主键，来标识每条数据。那么这样就要求数据中id的值不能重复，不能为null值。

**检查约束： 关键字是** **CHECK**（mysql没有）

保证列中的值满足某一条件。

例如：我们可以给age列添加一个范围，最低年龄可以设置为1，最大年龄就可以设置为300，这样的数据才更合理些。

**默认约束： 关键字是** **DEFAULT**

保存数据时，未指定值则采用默认值。

例如：我们在给english列添加该约束，指定默认值是0，这样在添加数据时没有指定具体值时就会采用默认给定的0。

**外键约束： 关键字是** **FOREIGN KEY**

外键用来让两个表的数据之间建立链接，保证数据的一致性和完整性。

外键约束现在可能还不太好理解，后面我们会重点进行讲解。

### 约束的使用

```mysql
CREATE table emp (
	id int primary key auto_incream, -- 员工id为主键
	ename varchar(50) not null unique, -- 非空且唯一
	joindate date not null, -- 入职 非空
	salary DOUBLE(7,2) not null, -- 工资 非空
	bonus DOUBLE(7,2) DEFAULt 0
);
# 如果没有按照约束来写会报错
insert into emp(id,ename,joindate,salary,bonus) VALUE(1,"张三","1998-04-26",22.5,1.2);

insert into emp(id,ename,joindate,salary,bonus) VALUES(null,"张三","1998-04-26",150.3,22.5),(null,"张ba","1998-04-26",152.3,null);

select * from emp;
```

#### 外键约束

让两个表的数据之间建立链接，保证数据的一致性和完整性

在创建表的时候，如果要添加外键，那么得先创建主表。之后再在另一个表中创建外键。

如果一个表中引用了外键，那么添加数据的时候，如果主表没有这个数据，则不能添加外键中的数据

```mysql
-- 建表添加外键
drop table if EXISTS emp;
create table emp(
	id int primary key,
	name varchar(10) not null ,
  age int,
	dep_id int
	
	-- 创建外键
	constraint fk_emp_dept foreign key(dep_id) REFERENCES dept(id)
);

-- 删除外键
ALTER TABLE emp drop FOREIGN key fk_emp_dept;

-- 添加外键

alter table emp add CONSTRAINT fk_emp_dept FOREIGN key(dep_id) REFERENCEs dept(id);
```

## 1.6  数据库设计

![image-20220927184524265](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209271845606.png)

### 设置概念

**根据**

- 建立数据库中的表结构以及表与表之间的关联关系的过程

- 建立数据库中的表结构以及表与表之间关联关系的过程

- 有那些表，表里有那些字段，有什么关系

**数据库设计的步骤**

- 需求分析 （数据是什么，数据具有那些属性）
- 逻辑分析  （通过er图进行建模）
- 物理设计 （根据数据库自身特点把逻辑设计转换为物理设计）
- 维护设计 （1，对新的需求进行建表，2.表优化）

### 表的关系

- 一对多
  - 部门和员工
  - 一个部门对应多个员工，一个员工对应一个部门
- 一对一
  - 一个人对应一个身份证
  - 一对一关系多用于表的拆分
- 多对多
  - 商品和订单
  - 一个商品对应多个订单，一个订单包含多个商品

### 如何实现

**多对多**

要借助第三个表来实现

![image-20220927193425166](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209271934321.png)

**一对一**

![image-20220927204627053](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209272046158.png)

### **案例**（豆瓣音乐）

![image-20220927205157480](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209272051595.png)

```mysql
# 创建过程
DROP table if exists music ;
CREATE TABLE music (
		id INT PRIMARY KEY,
		song_id int,
		title VARCHAR ( 32 ) UNIQUE,
		alias VARCHAR ( 32 ),
		image VARCHAR ( 64 ) NOT NULL,
		style VARCHAR ( 8 ) NOT NULL,
		type VARCHAR ( 4 ) NOT NULL,
	artist VARCHAR ( 16 ) NOT NULL,

-- 外键
	CONSTRAINT fk_music_song FOREIGN key(song_id) REFERENCES song(id)

	);
	
	drop table if  EXISTS song;
	CREATE table song(
		id int primary key,
		name varchar(32) not null,
		serial_number tinyint
	);
	
	drop table if exists review;
	create table review(
		id varchar(16) PRIMARY key,
		user_id int,
		song_id int,
		content varchar(256),
		rating tinyint,
		review_time date,
		
		-- 外键
		CONSTRAINT fk_review_song FOREIGN key(song_id) REFERENCES song(id),
		CONSTRAINT fk_review_user FOREIGN key(user_id) REFERENCES user(id)
	);
	
	drop table if exists user;
	create table user(
		id int primary key,
		username varchar(16) UNIQUE,
		image varchar(64),
		signature varchar(64),
		nickname varchar(16)
		
	
	)
	
	
	-- 实现多对多关系 要再建一个表
	drop table if exists user_song;
	create table user_song(
		id int PRIMARY key UNIQUE,
		user_id int,
		song_id int,
		
		CONSTRAINT fk_us_user FOREIGN KEY(user_id) REFERENCES user(id),
		CONSTRAINT fk_us_song FOREIGN key(song_id) references song(id)
	);
```

![image-20220927213352961](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209272133051.png)

## 1.7 多表查询（9.28）

![image-20220928180621014](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209281806220.png)

```mysql
# 如果直接用两个表来查询，则会出现笛卡尔积
select * from emp,dept;

# 内连接
select * from emp , dept where emp.dep_id = dept.did
```

### 内连接

![image-20220928180736116](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209281807202.png)

```mysql
-- 隐式内连接
select * from emp,dept where emp.dep_id = dept.did;

-- 查询 emp 的 name,gender,dept 表的dname

select emp.id,emp.`name`,dept.did,dept.dname from dept,emp where dept.did = emp.id;

-- 给表起别名
select e1.id,d1.dname from emp e1,dept d1 where e1.id = d1.did;

-- 显式内连接
select * from emp inner join dept on emp.id = dept.did;
-- 可不写 inner
select * from emp join dept on emp.id = dept.did;
```

### 外连接

```mysql
-- 一般使用的是左连接
-- 左外连接查询的是左边的表和右边的表的交集
select * from emp left join dept on emp.id = dept.did;
-- 右外连接查询的是右边的表和左边的表的交集
select * from emp right join dept on emp.id = dept.did
```

### 子查询

![image-20220928185436790](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209281854917.png)

把需要查询两次的sql合并成一次查询，把子查询嵌套到查询；

```mysql
-- 查询市场部和财务部员工信息
select did from dept where dname in ("市场部","财务部");
-- 多行多列
select * from emp where dep_id in (select did from dept where dname in
("市场部","财务部"));

-- 查询入职日期是 '2011-11-11' 之后的员工信息和部门信息

-- 个人方法
select * from emp left join dept on emp.dep_id = dept.did
where join_date > "2011-11-11";

-- 查询入职日期是 '2011-11-11' 之后的员工信息

select * from emp where join_date > '2011-11-11' ;

-- 多表查询使用 虚拟表查询
select * from (select * from emp where join_date > '2011-11-11' ) t1, dept where t1.dep_id = dept.did;
```

表信息

![image-20220928192734203](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209281927299.png)

```mysql
# 小练习
-- 1.查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
select emp.id,emp.ename,salary,job.jname,job.description from emp left join job on emp.job_id = job.id
-- 2.查询员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
select emp.id,ename,salary,job.jname,job.description,dept.dname,dept.loc from emp
left join job on emp.job_id = job.id
left join dept on emp.dept_id = dept.id;
-- 3.查询员工姓名，工资，工资等级
select emp.ename,salarygrade.grade from emp,salarygrade where emp.salary < salarygrade.hisalary and salary >= salarygrade.losalary

-- 5.查询出部门编号、部门名称、部门位置、部门人数
-- 虚拟表查询
select * from dept,(select count(*),dept_id from emp
GROUP by dept_id) t1 where dept.id = t1.dept_id
```

## 1.8 事务

![image-20220928193245365](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202209281932505.png)

转账时，假如断电了，数据库没有操作完成，这个时候就需要恢复原来的状况。事务把所有的转账命令作为一个整体来运行，做到成功同时成功，失败同时失败。

```mysql
-- 开启事务 
begin;
-- 查询李四的余额
-- 李四的金额-500
update account set money = money - 500 where name = '李四';

-- 张三的金额+500
update account set money = money + 500 where name = '张三';
-- 提交事务
commit;
-- 回滚事务
rollback;
select * from account;
```

### 事务的四大特征(acid)

- 原子性	事务是不可以分隔的最小操作单位，要么同时成功，要么同时失败
- 一致性    事务完成时，必须使所有的数据都保持一致的状态
- 隔离性    多个事务之间，操作的可见性
- 持久性    事务一旦提交或回滚，它对数据库中的数据的改变就是永久的



# 2. JDBC (10.2)

## 2.1 快速入门

java database connecivity 操作关系型数据库的一套API

jdbc定义了一套接口，可以操作所有的关系型数据库

![image-20221002190817308](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210021908456.png)

我们使用的是提供的接口，访问不同数据库提供的jar包

### 2.1.1 怎么使用

![image-20221002191329286](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210021913377.png)

```java
// 快速入门
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册驱动
        //1.5 之后可以不用写
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        /创建连接
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        int execute = statement.executeUpdate("UPDATE emp set bonus = 999 where id = 1001");

        System.out.println(execute);

        statement.close();
        connection.close();


    }
}
```

### 2.1.2 DriverManger

管理一组jdbc驱动程序的基本服务，是一个工具类

class.forname() 在1.5之后可以不写

```java
jdbc:mysql://127.0.0.1:3306/数据库名称?参数键值对
```

出现警告的时候需要在后面加入useSSL=false

连接本机可以用 ` jdbc:mysql:///数据库名称`

### 2.1.3 Connnection

1. 获取执行SQL的对象
2. 执行事务

![image-20221003121352327](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210031213690.png)

```java
public class JDBCaffair {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        //开启事务
        try {
            connection.setAutoCommit(false);
            Statement statement1 = connection.createStatement();
            statement1.executeUpdate("UPDATE emp set bonus = 999 where id = 1001");
            Statement statement2 = connection.createStatement();
            statement1.executeUpdate("update emp set bonus = 975 where id = 1002");
            //提交事务
            connection.commit();
            //关闭连接
            statement1.close();
            statement2.close();
        } catch (Exception e) {
            //如果出错回滚事务
            connection.rollback();
            System.out.println("回滚事务");
            e.printStackTrace();

        }

        connection.close();
    }
}
```

### 2.1.4 Statement

![image-20221003124826881](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210031248976.png)

### 2.1.5 ResultSet

![image-20221003130231847](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210031302971.png)

```java
    @Test
    public void test_dml() throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from emp");

        while (resultSet.next()){
            //通过列的编号来获得数据，当然也可以通过列名来获得数据
            String date = resultSet.getString(1);
            String date1 = resultSet.getString(2);
            String date2= resultSet.getString(3);
            String date3 = resultSet.getString(4);
            String date4 = resultSet.getString(5);
            String date5 = resultSet.getString(6);
            String date6 = resultSet.getString(7);
            String date7 = resultSet.getString(8);

            System.out.println(date + '\t' +date1 + '\t'+date2 + '\t'+date3 + '\t'+date4 + '\t'+date5 + '\t'+date6 + '\t'+date7);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

```

#### 小例子

```java
    /*
    这是一个获取数据库数据后，传递到list列表
     */
    @Test
    public void test_dmltest() throws ClassNotFoundException, SQLException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from job");
        //新建一个列表，这里用的是多态，arraylist是list的子类。但是实现后还只有list的功能
        List<job> jobList = new ArrayList<>();
        //
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String jname = resultSet.getString("jname");
            String description = resultSet.getString("description");
            System.out.println(jname);
            job job = new job(id,jname,description);
            jobList.add(job);
        }
        System.out.println(jobList.toString());
    }
```

### 2.1.6 PreparedStatement

预编译SQL语句并执行: 预防SQL注入

sql注入是通过修改定义好的sql语句来改变软件进程

```java
String password = "'' or '1' = '1' "
    
    "jdbc:mysql://localhost:3306/student?useServerPrepStmts = true
    //开启预编译 不
    useServerPrepStmts=true;
```

![image-20221003154523728](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210031545857.png)

```java
    @Test
    public void parperState() throws SQLException, ClassNotFoundException {
        // 注册服务
        Class.forName("com.mysql.jdbc.Driver");

        //创建数据库的连接
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        String user = "root";
        String password = "a11816811";
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement preparedStatement = connection.prepareStatement("select * from job where id = ?");
        String name = "董事长";
        int id = 1;
        //preparedStatement.setString(1,name);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){

            String description = resultSet.getString("description");
            System.out.println("查到了" + description);
        }
        }
    /*
    防止sql注入需要使用parperStatement方法，Statement方法容易造成sql注入的问题，因为
    使用的是拼接字符串 
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //注册服务
        Class.forName("com.mysql.jdbc.Driver");
        // JDBC连接
        String user = "root";
        String password = "a11816811";
        String url = "jdbc:mysql://127.0.0.1:3306/student?useSSL=false";
        Connection connection = DriverManager.getConnection(url, user, password);
//        查询id和salary是否都符合，如果不符合则登录失败，符合则成功
        PreparedStatement preparedStatement = connection.prepareStatement("select id,salary from emp where id = ? and salary = ?");
        preparedStatement.setInt(1,1001);
        preparedStatement.setBigDecimal(2,new BigDecimal(8000));
        
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet);
//        拿到结果开始判断，是否有数据，没有则失败
        if (resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

    }
```



### 2.1.7 预编译功能 PreparedStatement

> PreparedStatement 好处：
>
> * 预编译SQL，性能更高
> * 防止SQL注入：==将敏感字符进行转义==



Java代码操作数据库流程如图所示：

* 将sql语句发送到MySQL服务器端

* MySQL服务端会对sql语句进行如下操作

  * 检查SQL语句

    检查SQL语句的语法是否正确。

  * 编译SQL语句。将SQL语句编译成可执行的函数。

    检查SQL和编译SQL花费的时间比执行SQL的时间还要长。如果我们只是重新设置参数，那么检查SQL语句和编译SQL语句将不需要重复执行。这样就提高了性能。

  * 执行SQL语句

接下来我们通过查询日志来看一下原理。

* 开启预编译功能

  在代码中编写url时需要加上以下参数。而我们之前根本就没有开启预编译功能，只是解决了SQL注入漏洞。

  ```sql
  useServerPrepStmts=true
  ```

```java
String url = "JDBC://mysql://127.0.0.1:3306/student?useSSL=false&useServerPrepStmts=true"
```



### 2.1.9 如何设置mysql数据库日志

my.ini配置方法

https://blog.csdn.net/gb4215287/article/details/106536026

如果发现ini文件不能成功加载，需要重新设置服务

https://blog.csdn.net/Burnup_110/article/details/115079157?

mysql 日志时间与 本地时间不一致需要添加

```ini
[mysqld]
log_timestamps=SYSTEM
```

设置数据库查询可以参考上面两个连接

```ini
# 数据库my.ini 配置文件
[mysqld]
#设置3306端口号
port=3306
#设置MySQL的安装目录
basedir= C:\\Program Files\\MySQL\\MySQL Server 5.7
#设置MySQL数据库的数据存放目录
datadir=C:\\Program Files\\MySQL\\MySQL Server 5.7\\data
#运行最大连接数
max_connections=200
#运行连接失败的次数。这也是为了防止有人从该主机试图攻击数据库系统
max_connect_errors=10
#服务端使用的字符集默认为utf-8
character-set-server=utf8

#General and Slow logging.

log-output=FILE

general-log=1
general_log_file="mysql.log"
slow-query-log=1
slow_query_log_file="mysql_slow.log"
long_query_time=2

[mysql]
#客户端使用的字符集默认为utf8
default-character-set=utf8

```

## 2.2  数据库连接池(Driud)

![image-20221020175939340](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210201759451.png)

> 
>
> * 数据库连接池是个容器，负责分配、管理数据库连接(Connection)
> * 它允许应用程序重复使用一个现有的数据库连接，而不是再重新建立一个；
> * 释放空闲时间超过最大空闲时间的数据库连接来避免因为没有释放数据库连接而引起的数据库连接遗漏
> * 好处
>   * 资源重用
>   * 提升系统响应速度
>   * 避免数据库连接遗漏

标准接口: DataSource

Druid（德鲁伊）

* Druid连接池是阿里巴巴开源的数据库连接池项目 

* 功能强大，性能优秀，是Java语言最好的数据库连接池之一



```java
    @Test
    public void DruidTest() throws Exception {
//        先导入jar包
//        创建配置文件 druid.poperties
//        用properties来loadproperties文件
        System.out.println(System.getProperty("user.dir")); //获取目前的路径，之后需要读文件的时候把后面没有的填到相对路径中
        Properties pr = new Properties();
        pr.load(new FileInputStream("druid.properties"));
        System.out.println(pr);
//        用druid来获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pr);
//          获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
```

配置文件

```properties
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true
username=root
password=1234
# 初始化连接数量
initialSize=5
# 最大连接数
maxActive=10
# 最大等待时间
maxWait=3000
```

## 2.3 练习

商品品牌数据的增删改查操作

# 3.maven(10.22)

![image-20221022154417289](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221544815.png)

## 3.1 maven 简介

> Apache Maven 是一个项目管理和构建的工具，它基于项目对象模型的概念，通过一小段描述信息来管理项目的构建，报告和文档

![image-20221022155634838](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221556013.png)

###  3.1.1 仓库

- 本地仓库
  - 自己电脑里面的仓库，你下载了就有

- 中央仓库 
  - maven官方维护的，几乎所有jar包都有
  - 要钱的没有

- 远程仓库
  - 一般由公司团队搭建的私有仓库

如果仓库中有，则直接引用。没有则从中央仓库下载。

如果架设了私服，则会下载到远程仓库，之后再传递到远程仓库

## 3.2 安装maven

### 配置环境变量

先添加maven路径

![image-20221022180236713](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221802794.png)

添加环境变量

![image-20221022175748894](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221757040.png![image-20221022180046369](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221800447.png)

### 配置本地仓库位置

打开`conf`文件夹中的`setting.xml`

添加一行

```xml
# 设定本地仓库位置，默认为c盘  
<localRepository>D:\software\apache-maven-3.8.6\apache-maven-3.8.6\rept\</localRepository>
```

### 设置阿里云镜像

```xml
#添加镜像   
<mirror>
      <id>alimaven</id>
      <mirrorOf>central</mirrorOf>
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/pulic/</url>
    </mirror>
```

## 3.3 Maven 基本使用

### 3.3.1 基础命令

- compile 编译 mvn complie
- clean 清除 mvn clean
- package 打包 mvn package
- test 测试 mvn test
- install 安装 mvn install 

### 3.3.2 生命周期

![image-20221022184952356](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221849500.png)

先执行前面的，再执行后面的

## 3.4 IDEA 配置Maven

idea自带maven 用自己的得修改maven路径

maven坐标（资源的唯一标识）

- groupId: 定义当前Maven项目隶属组织名称
- artifactld: 定义当前Maven项目名称
- version: 定义当前项目版本号

![image-20221022185924042](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210221859170.png)

![image-20221025150523284](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251505452.png)



### 3.4.1 导入maven项目![image-20221025151806000](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251518265.png)

![image-20221025152008926](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251520011.png)

### 3.4.2 maven helper

![image-20221025152222715](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251522823.png)

## 3.5 依赖管理

寻找组件依赖可以选择 

组件名称 + maven 进行搜索

![image-20221025152720090](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251527243.png)

![image-20221025153028415](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251530531.png)

![image-20221025153052493](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251530629.png)

## 3.6 依赖范围

![image-20221025155340636](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251553759.png)

# 4. mybatis

> 免除了几乎所有的jdbc代码
>
> MyBatis 是一款优秀的持久层框架，用于简化 JDBC 开发MyBatis 本是 Apache 的一个开源项目iBatis, 2010年这个项目由apache software foundation 迁移到了google code，并且改名为MyBatis 。2013年11月迁移到Github官网：https://mybatis.org/mybatis-3/zh/index.html 

![image-20221025155525642](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210251555729.png)

- 框架就是一个半成品软件，是一套可重用的、通用的、软件基- 
- 础代码模型在框架的基础之上构建软件编写更加高效、规范通用、可扩展

## 4.1 快速入门

### 4.1.1 快速入门

mapper配置文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="test"> // 查询名称
    <select id="selectAll" resultType="com.hou.pojo.user">
        select * from tb_user
    </select>
</mapper>
```

数据库连接配置文件`mybatis-config.xml`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///mybatis?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="a11816811"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="mapper.xml"/>
    </mappers>
</configuration>
```

日志配置文件`logback.xml`

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <!--
        CONSOLE ：表示当前的日志信息是可以输出到控制台的。
    -->
    <appender name="Console" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>[%level]  %cyan([%thread]) %boldGreen(%logger{15}) - %msg %n</pattern>
        </encoder>
    </appender>

    <logger name="com.itheima" level="DEBUG" additivity="false">
        <appender-ref ref="Console"/>
    </logger>


    <!--

      level:用来设置打印级别，大小写无关：TRACE, DEBUG, INFO, WARN, ERROR, ALL 和 OFF
     ， 默认debug
      <root>可以包含零个或多个<appender-ref>元素，标识这个输出位置将会被本日志级别控制。
      -->
    <root level="DEBUG">
        <appender-ref ref="Console"/>
    </root>
</configuration>
```

```java
public class userSelect {
    public static void main(String[] args) throws IOException {
		//读取mybatis-config.xml配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建线程
        SqlSession sqlSession = sqlSessionFactory.openSession();
		//查询test下的selectAll 配置文件为mapper.xml
        List<user> user = sqlSession.selectList("test.selectAll");
        System.out.println(user.toString());
    }
}
```



### 4.1.2 使用idea 里的数据库连接器

![image-20221031053144575](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210310531419.png)

![](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210310532464.png)

## 4.2 Mapper 代理开发

![image-20221031054432765](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210310544928.png)

## 4.3 mybatis 核心配置文件

![image-20221031071911174](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202210310719572.png)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
        # 别名
    <typeAliases>
        <package name="com.hou.pojo"/>
    </typeAliases>
    <environments default="development"> //环境配置
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///mybatis?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="a11816811"/>
            </dataSource>
        </environment>
    </environments>
    <mappers> //代理配置
        <mapper resource="com/hou/mapper/userMapper.xml"/>
    </mappers>
</configuration>
```

## 4.4 查询

在查询的时候，因为实体类和数据库中的字段不同，就会出现查询出错的问题，这个时候有两种方式来解决。一个是查询的时候给字段起别名，另一种是用`resultMap`来进行结果的映射

```xml
<!--数据库里的字段名称和实体类的字段名称不匹配，所以会出现null的情况
    * 对不一样的列名起别名 可以解决这个问题
-->
    <select id="selectAll" resultType="com.hou.pojo.Brand">
        select id,brand_name as brandName,company_name as companyName,ordered,description,status from tb_brand
    </select>
<!--这样写比较的繁琐，可以使用sql代码块的方式-->
    <select id="selectAll" resultType="com.hou.pojo.Brand">
	select <include refid="select"/> from tb_brand
    </select>
<!--也可以使用结果映射的方式-->
<mapper namespace="com.hou.mapper.brandMapper">
    <resultMap id="selectBrand" type="com.hou.pojo.Brand">
        <result column="brand_name" property="brandName"/>
        <result column="company_name" property="companyName"/>
    </resultMap>
    <select id="selectAll" resultMap="selectBrand">
        select * from tb_brand
        
    </select>
```

## 4.5 查询详情

![image-20221107062640907](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211070626046.png)

### 参数占位符

*参数占位符：

1.#{}：会将其替换为？，为了防止SQL注入

2.${}：拼sql,会存在SQL注人问题

使用时机：

*参数传递的时候：#{}

*表名或者列名不固定的情况下：${}会存在SQL注入问题

*参数类型：parameterType：可以省略

*特殊字符

 1.  转义: 	&it

 2.  CDATA区: 

     ```xml
      <![CDATA[> 1 ]]>
     ```

     

```java
//xml   
<select id="selectByid" resultMap="selectBrand">
        select * from tb_brand where id = #{id}
    </select>
//mapper
List<Brand> selectByid(int id);
//test
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sql session
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        //开启查询
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectByid(2);

        System.out.println(brands);
```

---

## 4.6 多条件查询

![image-20221108100417011](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081004687.png)



```java
//注解方法
List<Brand> selectaa(@Param("companyName") String companyName ,@Param("brandName") String brandName,@Param("status") Integer status);
//构造方法
List<Brand> selectaa(Brand brand);
//map方法
List<Brand> selectaa(Map map);

        //数据
        String brandName = "%华为%";
        String companyName = "%华为%";
        HashMap<String,String> ObjectHashMap = new HashMap<String,String>();
        ObjectHashMap.put("brandName",brandName);
        ObjectHashMap.put("companyName",companyName);
```

### 动态sql

- if 完成对应的条件判断
- where  <where> 自动判断
- choose(when,otherwise)
- trim(where),

用户在填写查询内容的时候，不会全部填写选项。这个时候就需要动态sql

![image-20221108104353292](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081043597.png)

```xml
<select id="selectChose" resultMap="selectBrand">
    select * from tb_brand
    where 1=1
    <if test="companyName != null and companyName != '' ">
        and company_name like #{companyName}
    </if>
    <if test="brandName != null and brandName != ''" >
        and brand_name like #{brandName}
    </if>
    <if test="status != null">
        and status = #{status}
    </if>


</select>

<!--另一种方法-->
<select id="selectChoice" resultMap="selectBrand">
    select * from tb_brand
    <where>
        <if test="status != null">
          and  status = #{status}
        </if>
        <if test="brandName != null and brandName != '' ">
           and brand_name like #{brandName}
        </if>
        <if test="companyName != null and companyName != ''">
           and company_name like #{companyName}
        </if>
    </where>
</select>
```

### 单条件的动态条件查询

![image-20221108150909110](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081509460.png)

```xml
    <!--动态单个sql查询-->
    <select id="selectConditionByChoice" resultMap="selectBrand">
        select * from tb_brand
        where
        <choose>
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
            <otherwise>
                1=1
            </otherwise>
        </choose>
    </select>


    <!--使用where 关键字 可以省略 otherwise 默认值 ，因为会自动补全-->
    <select id="selectConditionByChoice1" resultMap="selectBrand">
        select * from tb_brand
        <where>
        <choose>
            
                
           
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
        </choose>
        </where>
    </select>
```

## 4.7 添加

![image-20221108155444409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081554697.png)

添加一条数据

```xml
    <insert id="addOne">
        insert into tb_brand(brand_name, company_name, ordered, description, status)
        values(#{brandName},#{companyName},#{ordered},#{description},#{status});
    </insert>
```

```java
    @Test
    public void addOne() throws IOException {
        //创建session
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();//这里填true就是自动提交
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        brand.setCompanyName("小米科技");
        brand.setDescription("为发烧而生");
        brand.setOrdered(1);
        brand.setStatus(1);
        mapper.addOne(brand);
        //手动提交，不提交则会出现rollback
        sqlSession.commit();

    }
```

## 4.5 查询详情

![image-20221107062640907](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211070626046.png)

### 参数占位符

*参数占位符：

1.#{}：会将其替换为？，为了防止SQL注入

2.${}：拼sql,会存在SQL注人问题

使用时机：

*参数传递的时候：#{}

*表名或者列名不固定的情况下：${}会存在SQL注入问题

*参数类型：parameterType：可以省略

*特殊字符

 1.  转义: 	&it

 2.  CDATA区: 

     ```xml
      <![CDATA[> 1 ]]>
     ```

     

```java
//xml   
<select id="selectByid" resultMap="selectBrand">
        select * from tb_brand where id = #{id}
    </select>
//mapper
List<Brand> selectByid(int id);
//test
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sql session
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        //开启查询
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectByid(2);

        System.out.println(brands);
```

---

## 4.6 多条件查询

![image-20221108100417011](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081004687.png)



```java
//注解方法
List<Brand> selectaa(@Param("companyName") String companyName ,@Param("brandName") String brandName,@Param("status") Integer status);
//构造方法
List<Brand> selectaa(Brand brand);
//map方法
List<Brand> selectaa(Map map);

        //数据
        String brandName = "%华为%";
        String companyName = "%华为%";
        HashMap<String,String> ObjectHashMap = new HashMap<String,String>();
        ObjectHashMap.put("brandName",brandName);
        ObjectHashMap.put("companyName",companyName);
```

### 动态sql

- if 完成对应的条件判断
- where  <where> 自动判断
- choose(when,otherwise)
- trim(where),

用户在填写查询内容的时候，不会全部填写选项。这个时候就需要动态sql

![image-20221108104353292](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081043597.png)

```xml
<select id="selectChose" resultMap="selectBrand">
    select * from tb_brand
    where 1=1
    <if test="companyName != null and companyName != '' ">
        and company_name like #{companyName}
    </if>
    <if test="brandName != null and brandName != ''" >
        and brand_name like #{brandName}
    </if>
    <if test="status != null">
        and status = #{status}
    </if>


</select>

<!--另一种方法-->
<select id="selectChoice" resultMap="selectBrand">
    select * from tb_brand
    <where>
        <if test="status != null">
          and  status = #{status}
        </if>
        <if test="brandName != null and brandName != '' ">
           and brand_name like #{brandName}
        </if>
        <if test="companyName != null and companyName != ''">
           and company_name like #{companyName}
        </if>
    </where>
</select>
```

### 单条件的动态条件查询

![image-20221108150909110](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081509460.png)

```xml
    <!--动态单个sql查询-->
    <select id="selectConditionByChoice" resultMap="selectBrand">
        select * from tb_brand
        where
        <choose>
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
            <otherwise>
                1=1
            </otherwise>
        </choose>
    </select>


    <!--使用where 关键字 可以省略 otherwise 默认值 ，因为会自动补全-->
    <select id="selectConditionByChoice1" resultMap="selectBrand">
        select * from tb_brand
        <where>
        <choose>
            
                
           
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
        </choose>
        </where>
    </select>
```

## 4.7 添加

![image-20221108155444409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081554697.png)

添加一条数据

```xml
    <insert id="addOne">
        insert into tb_brand(brand_name, company_name, ordered, description, status)
        values(#{brandName},#{companyName},#{ordered},#{description},#{status});
    </insert>
```

```java
    @Test
    public void addOne() throws IOException {
        //创建session
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();//这里填true就是自动提交
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        brand.setCompanyName("小米科技");
        brand.setDescription("为发烧而生");
        brand.setOrdered(1);
        brand.setStatus(1);
        mapper.addOne(brand);
        //手动提交，不提交则会出现rollback
        sqlSession.commit();

    }
```

## 4.5 查询详情

![image-20221107062640907](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211070626046.png)

### 参数占位符

*参数占位符：

1.#{}：会将其替换为？，为了防止SQL注入

2.${}：拼sql,会存在SQL注人问题

使用时机：

*参数传递的时候：#{}

*表名或者列名不固定的情况下：${}会存在SQL注入问题

*参数类型：parameterType：可以省略

*特殊字符

 1.  转义: 	&it

 2.  CDATA区: 

     ```xml
      <![CDATA[> 1 ]]>
     ```

     

```java
//xml   
<select id="selectByid" resultMap="selectBrand">
        select * from tb_brand where id = #{id}
    </select>
//mapper
List<Brand> selectByid(int id);
//test
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sql session
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        //开启查询
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectByid(2);

        System.out.println(brands);
```

---

## 4.6 多条件查询

![image-20221108100417011](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081004687.png)



```java
//注解方法
List<Brand> selectaa(@Param("companyName") String companyName ,@Param("brandName") String brandName,@Param("status") Integer status);
//构造方法
List<Brand> selectaa(Brand brand);
//map方法
List<Brand> selectaa(Map map);

        //数据
        String brandName = "%华为%";
        String companyName = "%华为%";
        HashMap<String,String> ObjectHashMap = new HashMap<String,String>();
        ObjectHashMap.put("brandName",brandName);
        ObjectHashMap.put("companyName",companyName);
```

### 动态sql

- if 完成对应的条件判断
- where  <where> 自动判断
- choose(when,otherwise)
- trim(where),

用户在填写查询内容的时候，不会全部填写选项。这个时候就需要动态sql

![image-20221108104353292](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081043597.png)

```xml
<select id="selectChose" resultMap="selectBrand">
    select * from tb_brand
    where 1=1
    <if test="companyName != null and companyName != '' ">
        and company_name like #{companyName}
    </if>
    <if test="brandName != null and brandName != ''" >
        and brand_name like #{brandName}
    </if>
    <if test="status != null">
        and status = #{status}
    </if>


</select>

<!--另一种方法-->
<select id="selectChoice" resultMap="selectBrand">
    select * from tb_brand
    <where>
        <if test="status != null">
          and  status = #{status}
        </if>
        <if test="brandName != null and brandName != '' ">
           and brand_name like #{brandName}
        </if>
        <if test="companyName != null and companyName != ''">
           and company_name like #{companyName}
        </if>
    </where>
</select>
```

### 单条件的动态条件查询

![image-20221108150909110](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081509460.png)

```xml
    <!--动态单个sql查询-->
    <select id="selectConditionByChoice" resultMap="selectBrand">
        select * from tb_brand
        where
        <choose>
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
            <otherwise>
                1=1
            </otherwise>
        </choose>
    </select>


    <!--使用where 关键字 可以省略 otherwise 默认值 ，因为会自动补全-->
    <select id="selectConditionByChoice1" resultMap="selectBrand">
        select * from tb_brand
        <where>
        <choose>
            
                
           
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
        </choose>
        </where>
    </select>
```

## 4.7 添加

![image-20221108155444409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081554697.png)

添加一条数据

```xml
    <insert id="addOne">
        insert into tb_brand(brand_name, company_name, ordered, description, status)
        values(#{brandName},#{companyName},#{ordered},#{description},#{status});
    </insert>
```

```java
    @Test
    public void addOne() throws IOException {
        //创建session
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();//这里填true就是自动提交
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        brand.setCompanyName("小米科技");
        brand.setDescription("为发烧而生");
        brand.setOrdered(1);
        brand.setStatus(1);
        mapper.addOne(brand);
        //手动提交，不提交则会出现rollback
        sqlSession.commit();

    }
```

## 4.5 查询详情

![image-20221107062640907](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211070626046.png)

### 参数占位符

*参数占位符：

1.#{}：会将其替换为？，为了防止SQL注入

2.${}：拼sql,会存在SQL注人问题

使用时机：

*参数传递的时候：#{}

*表名或者列名不固定的情况下：${}会存在SQL注入问题

*参数类型：parameterType：可以省略

*特殊字符

 1.  转义: 	&it

 2.  CDATA区: 

     ```xml
      <![CDATA[> 1 ]]>
     ```

     

```java
//xml   
<select id="selectByid" resultMap="selectBrand">
        select * from tb_brand where id = #{id}
    </select>
//mapper
List<Brand> selectByid(int id);
//test
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sql session
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        //开启查询
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectByid(2);

        System.out.println(brands);
```

---

## 4.6 多条件查询

![image-20221108100417011](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081004687.png)



```java
//注解方法
List<Brand> selectaa(@Param("companyName") String companyName ,@Param("brandName") String brandName,@Param("status") Integer status);
//构造方法
List<Brand> selectaa(Brand brand);
//map方法
List<Brand> selectaa(Map map);

        //数据
        String brandName = "%华为%";
        String companyName = "%华为%";
        HashMap<String,String> ObjectHashMap = new HashMap<String,String>();
        ObjectHashMap.put("brandName",brandName);
        ObjectHashMap.put("companyName",companyName);
```

### 动态sql

- if 完成对应的条件判断
- where  <where> 自动判断
- choose(when,otherwise)
- trim(where),

用户在填写查询内容的时候，不会全部填写选项。这个时候就需要动态sql

![image-20221108104353292](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081043597.png)

```xml
<select id="selectChose" resultMap="selectBrand">
    select * from tb_brand
    where 1=1
    <if test="companyName != null and companyName != '' ">
        and company_name like #{companyName}
    </if>
    <if test="brandName != null and brandName != ''" >
        and brand_name like #{brandName}
    </if>
    <if test="status != null">
        and status = #{status}
    </if>


</select>

<!--另一种方法-->
<select id="selectChoice" resultMap="selectBrand">
    select * from tb_brand
    <where>
        <if test="status != null">
          and  status = #{status}
        </if>
        <if test="brandName != null and brandName != '' ">
           and brand_name like #{brandName}
        </if>
        <if test="companyName != null and companyName != ''">
           and company_name like #{companyName}
        </if>
    </where>
</select>
```

### 单条件的动态条件查询

![image-20221108150909110](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081509460.png)

```xml
    <!--动态单个sql查询-->
    <select id="selectConditionByChoice" resultMap="selectBrand">
        select * from tb_brand
        where
        <choose>
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
            <otherwise>
                1=1
            </otherwise>
        </choose>
    </select>


    <!--使用where 关键字 可以省略 otherwise 默认值 ，因为会自动补全-->
    <select id="selectConditionByChoice1" resultMap="selectBrand">
        select * from tb_brand
        <where>
        <choose>
            
                
           
            <when test="companyName != null and companyName != ''">
                company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                brandName like #{brandName}
            </when>
        </choose>
        </where>
    </select>
```

## 4.7 添加

![image-20221108155444409](https://cdn.jsdelivr.net/gh/lamatehu/lamateimg//img/202211081554697.png)

添加一条数据

```xml
    <insert id="addOne">
        insert into tb_brand(brand_name, company_name, ordered, description, status)
        values(#{brandName},#{companyName},#{ordered},#{description},#{status});
    </insert>
```

```java
    @Test
    public void addOne() throws IOException {
        //创建session
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();//这里填true就是自动提交
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        brand.setCompanyName("小米科技");
        brand.setDescription("为发烧而生");
        brand.setOrdered(1);
        brand.setStatus(1);
        mapper.addOne(brand);
        //手动提交，不提交则会出现rollback
        sqlSession.commit();

    }
```

