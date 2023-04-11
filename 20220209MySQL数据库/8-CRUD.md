# INSERT语句

使用INSERT语句向表插入数据。

```mysql
INSERT INTO table_name(列名)
VALUES (值)
```

```mysql
CREATE TABLE goods (
	id INT,
	goods_name VARCHAR(10),
	price DOUBLE
);

-- 添加数据
INSERT INTO goods(id, goods_name, price)
				VALUES (1, '华为手机', 2000.01);
```

## 细节说明

1. 插入数据应该与字段的数据类型相同
2. 数据的长度应在规定范围内
3. 在value中列出的数据位置必须与被加入的列的排列位置相对应
4. 字符和日期类型应包含在单引号内
5. 列可以插入空值（前提是该字段允许为空），`insert into table value(null)`
6. `insert into table_name (列名...) values (),(),()` 添加多条记录
7. 如果是给表中的所有字段添加数据，可以不写前面的字段名称
8. 默认值的使用，当不给某个字段时，如果有默认值就会添加，否则报错

# UPDATE语句

使用UPDATE语句修改表中的数据

```mysql
UPDATE table_name
		SET col_name = expr1 [ ,  col_name2 = expr2]
		[WHERE where_definition]
```

```mysql
# 演示UPDATE语句

-- 将所有的员工薪水修改为5000
UPDATE employee SET salary = 5000;

-- 将姓名为 景风眠 的员工的薪水修改为9999
UPDATE employee SET salary = 9999 WHERE user_name = '景风眠';

-- 将 zephyr 的薪水在原有基础上增加1000
INSERT INTO employee VALUES(200, 'zephyr', '1999-11-11', '1999-11-11 10:10:10', '诗人', 8000, '诗', 'd:\a.jpg');

UPDATE employee SET salary = salary + 1000 WHERE user_name = 'zephyr';

```

## 细节说明

1. UPDATE语法可以用新值更新原有表行中的各列。
2. SET子句指示要修改哪些列和要给予哪些值。
3. WHERE子句指定应更新哪些行。如没有WHERE子句，则更新所有的行（记录）
4. 如果需要修改多个字段，可以通过set字段1=值1,字段2=值2....

# DELETE语句

```mysql
DELETE FROM table_name
		[WHERE where_definition]
```

```mysql
# 演示DELETE

-- 删除表中user_name为 景风眠 的记录
DELETE FROM employee WHERE user_name = '景风眠';

-- 删除表中所有的记录
DELETE FROM employee;
```

## 使用细节

1. 如果不使用where子句，将删除表中所有数据。
2. Delete语句不能删除某一列的值（可使用update 设为 null或者")
3. 使用delete语句仅删除记录，不删除表本身。如要删除表，使用drop table语句。drop table表名；

# SELECT语句

```mysql
SELECT [DISDINCT] * | {col1, col2, col3, ...} FROM table_name;
```

- `DISDINCT`可以指定筛选结果去重

```mysql
-- 创建新的表（student
CREATE TABLE student (
	id INT NOT NULL DEFAULT 1,
	`name` VARCHAR ( 20 ) NOT NULL DEFAULT '',
	chinese FLOAT NOT NULL DEFAULT 0.0,
	english FLOAT NOT NULL DEFAULT 0.0,
	math FLOAT NOT NULL DEFAULT 0.0 
);
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 1, '韩顺平', 89, 78, 90 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 2, '张飞', 67, 98, 56 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 3, '宋江', 87, 78, 77 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 4, '关羽', 88, 98, 90 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 5, '赵云', 82, 82, 67 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 6, '欧阳锋', 55, 85, 45 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 6, '欧阳锋', 55, 85, 45 );
INSERT INTO student ( id, `name`, chinese, english, math )
VALUES
	( 7, '黄蓉', 75, 65, 30 );
	
SELECT * FROM student;

-- 查询表中所有学生的信息
SELECT * FROM student;
-- 查询表中所有的学生和对应的英文成绩
SELECT `name`, english FROM student;
-- 过滤表中的重复数据
SELECT DISTINCT english FROM student;


```

- 使用表达式对查询的列进行运算

  ```mysql
  SELECT *  |  {col1, col2, col3, ...| expression, ...} FROM table_name
  ```

- 使用`as`取别名

  ```mysql
  SELECT origin_name AS new_name from tabel_name
  ```

```mysql
# select练习

-- 统计每个学生的总分
SELECT `name`, (chinese+english+math) FROM student;
-- 所有学生总分+10的情况
SELECT `name`, (chinese+english+math+10) total_score FROM student;
-- 使用别名表示学生分数
SELECT `name`, (chinese+english+math) AS total_score FROM student;
```

## 在WHERE子句中经常使用的运算符

![image-20220215193540229](https://s2.loli.net/2022/02/15/7lCcvgwPzr2IFWQ.png)

## ORDER BY 语句

![image-20220221155937748](https://s2.loli.net/2022/02/21/D9hdgSl6EPypQms.png)

```mysql
# 演示ORDER BY的使用

-- 对数学成绩排序后输出（升序）
SELECT * from student ORDER BY math; -- 默认是升序的
-- 对总分按从高到低的顺序输出
SELECT *,(chinese+english+math) as total_score from student ORDER BY (chinese+english+math);
-- 对姓李的学生成绩排序输出（升序）
SELECT *, (chinese+english+math) as total_score FROM student WHERE `name` LIKE '李%' ORDER BY total_score;
```

## 合计/统计函数 

### COUNT

![image-20220221161003031](https://s2.loli.net/2022/02/21/sfSCdMqgne1HuZm.png)

```mysql
# 演示mysql的统计函数的使用

-- 统计一个班级共有多少学生？
SELECT COUNT(*) FROM student;
-- 统计数学成绩大于30的学生有多少个？
SELECT COUNT(*) FROM student WHERE math>30;
-- 统计总分大于250的人数有多少？
SELECT COUNT(*) FROM student WHERE (english+math+chinese)>30;
-- count(*)和count(列)的区别
-- count(*) 返回满足条件的记录的行数
-- count(列) 统计满足条件的某列有多少个，但是会排除null
CREATE TABLE t12 (
	`name` VARCHAR(20)
);
INSERT INTO t12 VALUES('tom');
INSERT INTO t12 VALUES('jack');
INSERT INTO t12 VALUES('mary');
INSERT INTO t12 VALUES(NULL);
SELECT * FROM t12; -- 4行数据
SELECT COUNT(*) FROM t12; -- 4
SELECT COUNT(`name`) FROM t12; -- 3
```

### SUM![image-20220221162039131](https://s2.loli.net/2022/02/21/T6AM5QyudJjLRBH.png)

```mysql
# 演示sum函数

-- 统计一个班级数学总成绩？
SELECT SUM(math) FROM student;
-- 统计一个班级语文、英语、数学各科的总成绩
SELECT SUM(math) as math_total_score, SUM(chinese) as chinese_total_score, SUM(english) as english_total_score from student;
-- 统计一个班级语文、英语、数学的成绩总和
SELECT sum(math+english+chinese) FROM student;
-- 统计一个班级语文成绩平均分
SELECT sum(chinese)/COUNT(chinese) from student;
```

### AVG

```mysql
-- 演示AVG函数

-- 求一个班级数学成绩平均分
SELECT AVG(math) FROM student;
```

### MAX / MIN

```mysql
# 演示MAX 和 MIN
-- 求班级总成绩最高分和最低分
SELECT MAX(chinese+english+math) FROM student;
-- 求一个班级数学成绩最高分
SELECT MAX(math) FROM student;
```

## GROUP BY / HAVING语句

![image-20220221163014333](https://s2.loli.net/2022/02/21/RaBXA4tuY1zwFoI.png)

```mysql
CREATE TABLE dept (
/*部门表*/
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,
	dname VARCHAR ( 20 ) NOT NULL DEFAULT "",
	loc VARCHAR ( 13 ) NOT NULL DEFAULT "" 
);
INSERT INTO dept
VALUES
	( 10, 'ACCOUNTING', 'NEW YORK' ),
	( 20, ' RESEARCH', ' DALLAS' ),
	( 30, ' SALES', ' CHICAGO' ),
	( 40, 'OPRATIONS', 'BOSTON' );
SELECT
	* 
FROM
	dept;
	
# 创建表EMP雇员
CREATE TABLE emp (
	empno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0,/*编号*/
	ename VARCHAR ( 20 ) NOT NULL DEFAULT "",/*名字*/ 
	job VARCHAR ( 9 ) NOT NULL DEFAULT "",/*工作*/
	mgr MEDIUMINT UNSIGNED,/*上级编号*/
	hiredate DATE NOT NULL,/*入职时间*/
	sal DECIMAL (7, 2) NOT NULL,/*薪水*/
	comm DECIMAL (7, 2),/*红利*/
	deptno MEDIUMINT UNSIGNED NOT NULL DEFAULT 0 /*部门编号*/
	);
	
INSERT INTO emp VALUES
(7369,'SMITH','CLERK',7902,'1990-12-17',800.00,NULL,20),
(7499,'ALLEN','SALESMAN',7698,'1991-2-20',1600.00,300.00,30),
(7521,'WARD','SALESMAN',7698,'1991-2-22',1250.00,500.00,30),
(7566,'JONES','MANAGER',7839,'1991-4-2',2975.00,NULL,20),
(7654,'MARTIN','SALESMAN',7698,'1991-9-28',1250.00,1400.00,30),
(7698,'BLAKE','MANAGER',7839,'1991-5-1',2850.00,NULL,30),
(7782,'CLARK','MANAGER',7839,'1991-6-9',2450.00,NULL,10),
(7788,'SCOTT','ANALYST',7566,'1997-4-19',3000.00,NULL,20),
(7839,'KING','PRESIDENT',NULL,'1991-11-17',5000.00,NULL,10),
(7844,'TURNER','SALESMAN',7698,'1991-9-8',1500.00,NULL,30),
(7900,'JAMES','CLERK',7698,'1991-12-3',950.00,NULL,30),
(7902,'FORD','ANALYST',7566,'1991-12-3',3000.00,NULL,20),
(7934,'MILLER','CLERK',7782,'1992-1-23',1300.00,NULL,10);

# 工资级别表
CREATE TABLE salgrade(
grade MEDIUMINT UNSIGNED NOT NULL DEFAULT 0, /*工资级别*/
losal DECIMAL ( 17 , 2 ) NOT NULL, /*该级别的最低工资*/
hisal DECIMAL ( 17 , 2 ) NOT NULL /*该级别的最高工资*/
);

INSERT INTO salgrade VALUES (1,700,1200);
INSERT INTO salgrade VALUES (2,1201,1400);
INSERT INTO salgrade VALUES (3,1401,2000);
INSERT INTO salgrade VALUES (4,2001,3000);
INSERT INTO salgrade VALUES (5,3001,9999);

SELECT * FROM salgrade;
```

```mysql
	
# 演示group by 和 having
-- GROUP by用于对查询的结果分组统计，(示意图）
-- having子句用于限制分组显示结果.
-- ?如何显示每个部门的平均工资(avg)和最高工资(max)
SELECT avg(sal), max(sal), deptno from emp GROUP BY deptno;
-- ?显示每个部门的每种岗位的平均工资和最低工资
SELECT deptno, job, avg(sal), min(sal) from emp GROUP BY deptno, job;
-- ?显示平均工资低于2000的部门号和它的平均工资//别名
SELECT avg(sal) as avg_sal, deptno from emp GROUP BY deptno HAVING avg_sal < 2000;
```

