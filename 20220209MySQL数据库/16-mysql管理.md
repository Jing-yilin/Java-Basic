# MySQL管理

![image-20220306181313192](https://s2.loli.net/2022/03/06/o8sDkYXuKdUazrN.png)

![image-20220306181407637](https://s2.loli.net/2022/03/06/xaXbQIRYP4HypUT.png)

![image-20220306183119064](https://s2.loli.net/2022/03/06/f7HTBzLkdMum1Ww.png)

![image-20220306183334657](https://s2.loli.net/2022/03/06/Ocv1P8TFpSH3i9o.png)

```mysql
-- mysql用户管理

-- 原因：当我们做项目开发时，可以根据不同的开发人员，赋予他们相应的操作权限
-- 所以，mysql数据库管理人员(root)，根据需要创建不同的用户，赋予相应的权限

-- 1.创建新用户
-- 注意：存放的是加密后的密码
CREATE USER 'hsp_edu'@'localhost' IDENTIFIED BY '123456';

SELECT `Host`, `User`, `authentication_string` FROM mysql.user;

-- 2.删除用户
DROP USER 'hsp_edu'@'localhost';

-- 3.登录

-- 4.用户修改密码
-- 修改自己的密码
SET PASSWORD = PASSWORD('abcdefg');
-- 修改其他人的密码需要权限
SET PASSWORD FOR 'root'@'jyl' = PASSWORD('123456')
```

# 权限管理

![img](https://pic4.zhimg.com/80/v2-c728eac606a79231f2d7681b24a03d73_1440w.jpg)

![image-20220306184153202](https://s2.loli.net/2022/03/06/nQrYl9Pja2Sop6v.png)

![image-20220306184458571](https://s2.loli.net/2022/03/06/D4Ipvi7Q8xfWUKa.png)

## 管理细节

![image-20220306190221295](https://s2.loli.net/2022/03/06/ZB4OCaLdHQmgky6.png)

![image-20220306190447267](https://s2.loli.net/2022/03/06/Oab9gXkpfoA5rRH.png)

```mysql
-- 1.在创建用户的时候，如果不指定Host,则为%,%表示表示所有IP都有连接权限create user XXX;

CREATE USER jack;

SELECT `host`, `user` FROM mysql.user;

-- 2.你也可以这样指定create user xxx'@'192.168.1.%'表示xxx用户在192.168.1.*的ip可以登录mysql
CREATE USER 'smith'@'192.168.1.%';
-- 3.在删除用户的时候，如果host不是%,需要明确指定'用户'@'host值'

DROP USER jack; -- 默认就是 DROP USER 'jack'@'%'
DROP USER 'smith'@'192.168.1.%';

```

