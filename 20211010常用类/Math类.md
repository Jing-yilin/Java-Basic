# Math类

## MathMethod.java

```java
//看看一些常用方法(静态方法)
        //1.abs 绝对值
        int abs = Math.abs(9);
        System.out.println(abs);//9
        //2.pow 求幂
        double pow = Math.pow(-3.5, 4);
        System.out.println(pow);//150.0625
        //3.ceil 向上取整，返回>=该参数的最小整数
        double ceil = Math.ceil(-3.01);
        System.out.println(ceil);//-3.0
        //4.floor 向下取整，返回<=该参数的最大整数
        double floor = Math.floor(-4.99);
        System.out.println(floor);//-5.0
        //5.round 四舍五入 Math.floor(该参数+0.5)
        long round = Math.round(-5.01);
        System.out.println(round);//-5
        //6.sqrt 求开方
        double sqrt = Math.sqrt(-9.0);
        System.out.println(sqrt);//NaN
        //7.random 求随机数
        //  random 返回[0, 1)之间的随机小数
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Math.random());
//        }
        //想办法获取[2, 7]范围内的随机数
        System.out.println(2+(int)(Math.random()*6));
        //8.max,min 返回两数的最大值和最小值
        int max = Math.max(1, 9);
        int min = Math.min(45, 90);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
```

