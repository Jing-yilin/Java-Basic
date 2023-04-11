---
typora-copy-images-to: images
---

# 综合项目：房屋出租系统

- 项目需求：实现基于文本界面的《房屋出租系统》。
  能够实现房屋信息的添加、修改和删除（使用数组），并能够打印房屋明细表

- 项目设计-程序框架图（分层模式=>当软件比较复杂，需要管理模式）

## 框架图
1. 系拥有哪些类【文件】
2. 明确类之间的调用关系

### Houseview.java <=> 类[界面]
1. 显示界面
2. 接受用户的输入
3. 调用HouseService完成对房屋信息的各种操作

### HouseService.java <=> 类[业务层]
1. 相应HouseView的调用
2. 完成房屋信息的各种操作（增删改查crud）create, read, update, delete

### House.java <=> 类[domain/model/模型层]
1. 一个House对象表示一个房屋信息

### HouseRentApp.java
```java
main(){//程序入口
    //创建HouseView对象
    //调用该对象，显示主菜单
        }
```