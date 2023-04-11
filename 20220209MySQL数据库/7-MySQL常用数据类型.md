# MySQL常用数据类型(列类型)

![image-20220211114406559](https://s2.loli.net/2022/02/11/5Ioe9NUH714vQs2.png)

[MySQL 数据类型 | 菜鸟教程 (runoob.com)](https://www.runoob.com/mysql/mysql-data-types.html)

## 演示整型

```mysql
# 演示tinyint

# 如果没有指定unsinged，则TINYINT是有符号的
CREATE TABLE t3 (
		id TINYINT
);

INSERT INTO t3 VALUES(127); # 添加语句

SELECT * FROM t3;

# 创建无符号tinyint
CREATE TABLE t4 (
		id TINYINT UNSIGNED
);

INSERT INTO t4 VALUES(255);
```

## 演示bit

```mysql
# 演示BIT类型的使用

# 1. bit(m) m 在 1-64
# 2. 添加数据   范围 按照给定的位数确定
# 3. 显示按照bit
CREATE TABLE t5 (
		num BIT(8) # 范围0-255
);

INSERT INTO t5 VALUES(255);
SELECT * FROM t5;
# 显示 11111111
SELECT * FROM t5 WHERE num = 255;

```

## 演示小数型

数值型（小数）的基本使用

1. `FLOAT/DOUBLE [UNSIGNED]`
2. `DECIMAL[M,D][UNSIGNED]`
   - 可以支持更加精确的小数位。M是小数位数（精度）的总数，D是小数点（标度）后面的位数。
   - 如果D是0,则值没有小数点或分数部分。M最大65。D最大是30。
   - 如果D被省略，默认是0。如果M被省略，默认是10。
   - 建议：如果希望小数的精度高，推荐使用decimal

```mysql
# 演示decimal、float、double

CREATE TABLE t6 (
	num1 FLOAT,
	num2 DOUBLE,
	num3 DECIMAL(30, 20)
);

# 添加数据
INSERT INTO t6 values(
	88.1234568912345,
	88.1234568912345,
	88.1234568912345
);

SELECT * FROM t6;
```

![image-20220213212249728](https://s2.loli.net/2022/02/13/bavtdABU7qGckzH.png)

## 演示字符串

- CHAR(size)
  固定长度字符串，最大255==字符==

- VARCHAR(size) 0~65535==字节== 【utf8最多21844字符 1-3字节用于记录大小】

  ```shell
  (65535 - 3) / 3 = 21844 # 使用utf8编码
  (65535 - 3) / 2 = 32766 # 使用gbk编码
  ```

```mysql
# 演示字符串使用 CHAR VARCHAR

# 演示字符串使用CHAR
CREATE TABLE t7(
	`name` CHAR(255)
);

# 演示使用utf8编码的VARCHAR
CREATE TABLE t8(
	`name` VARCHAR(21844)
);

# 演示使用gbk编码的VARCHAR
CREATE TABLE t9(
	`name` VARCHAR(32766)
) CHARACTER set gbk;
```

### 字符串使用细节

1.存放的是字符

```mysql
CHAR(4) #表示存放四个字符，不管中文英文

VARCHAR(4) #表示存放四个字符，不管中文英文
```

2.定长和变长

1. `CHAR(4)`是定长的，也就是说，及时输入`'aa'`，也会分配4个字符的空间

2. `varchar(4)`是变长的，也就是说，如果输入`'aa'`，实际空间不是4给字符（varchar本身还需要1-3个字节来记录存放内容的长度）

3.什么时候使用CHAR和VARCHAR?

1. 如果数据定长，比如手机号、身份证号，使用char
2. 如果数据长度不确定，使用varchar，比如文章
3. 查询速度 char > varchar

4.Text和VARCHAR

​	在存放文本时，可以使用Text数据类型，可以将Text视为VARCHAR列

​	注意：Text不能有默认值，大小 0-2^16字节

​	如果希望存放更多字符，可以选择MEDIUMTEXT 0-2^24 或者 LONGTEXT 0-2^32

```mysql
CREATE TABLE t10(
	content1 TEXT,
	content2 LONGTEXT,
	content3 MEDIUMTEXT
);
```

## 演示日期类型

```mysql
# 演示时间相关类型的使用
CREATE TABLE t11 (
	birthday DATE, -- 生日
	jobTime DATETIME, -- 记录年月日时分秒
	login_time TIMESTAMP -- 登录时间
	NOT NULL DEFAULT CURRENT_TIMESTAMP
	ON UPDATE CURRENT_TIMESTAMP
);
```

`NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP`的作用：

- 不允许为空
- 默认为当前时间
- 当修改的时候自动以当前时间更新

```mysql
INSERT INTO t11(birthday, jobTime)
						VALUES('2012-11-11', '2012-11-11 10:10:10');
SELECT * FROM t11;
```

![image-20220214214946627](https://s2.loli.net/2022/02/14/X3cQKPJiYAWqgw2.png)

可以看到，login_time是自动添加的当前时间。



如果更新该表的某条记录，`login_time`会自动以当前时间更新。







































