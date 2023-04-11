package com.hspedu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName HashSetIncrement
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/18 11:51
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class HashSetIncrement {
    public static void main(String[] args) {
        /*
        * 如果table数据大小达到临界值(0.75 * Capacity)
        * 就会进行扩容
        * 演示扩容
        * */
        HashSet hashSet = new HashSet();
//        for (int i = 0; i < 100; i++) {
//            hashSet.add(i);
//        }

        for (int i = 1; i <= 12; i++) {
            hashSet.add(new A(i));
        }

    }
}

class A {
    private int n;

    public A(int n) {
        this.n = n;
    }

//    @Override
//    public int hashCode() {
//        return 100;//巧妙地让他们的hash都一样
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return n == a.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
