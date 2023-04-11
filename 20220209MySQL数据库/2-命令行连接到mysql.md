连接到mysql服务的指令

`mysql -h 主机IP -P 端口 -u 用户名 -p密码`

> -p后面没有空格
>
> 如果-p后面没有密码，回车后会要求输入密码

我输入`mysql -h 127.0.0.1 -P 3306 -u root -pjyl`可以成功登录

![image-20220209170204711](https://s2.loli.net/2022/02/09/YdRzU29oI1wybLD.png)

> 如果没有写-h 主机，默认是本机
>
> 如果没有-P 端口，默认是3306

