package com.hspedu.collections_;

import java.util.*;

/**
 * @ClassName Collections_
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 16:54
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Collections_ {
    public static void main(String[] args) {
        //创建ArrayList集合进行测试

        List list = new ArrayList();
        list.add("jyl");
        list.add("cx");
        list.add("abba");
        list.add("babo");

        System.out.println("原始：" + list);//原始：[jyl, cx, abba, babo]

        //reverse()反转list
        Collections.reverse(list);
        System.out.println("reverse后：" + list);//reverse后：[babo, abba, cx, jyl]

        //shuffle(List) 对List集合进行随机排序
        Collections.shuffle(list);
        System.out.println("shuffle后：" + list);//shuffle后：[jyl, cx, abba, babo]

        //sort(List) 根据元素的自然顺序排序（升序排序）
        Collections.sort(list);
        System.out.println("sort后：" + list);//sort后：[abba, babo, cx, jyl]

        //sort(List, Comparator)：根据指定的Comparator产生的顺序对List集合元素进行排序
        //比如我希望按照字符串的长度进行排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("sort后：" + list);//sort[字符串长度排序]后：[abba, babo, cx, jyl]

        Collections.swap(list, 0, 1);
        System.out.println("swap后：" + list);//swap后：[jyl, cx, abba, babo]

//        1. Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("自然顺序的最大值：" + Collections.max(list));//自然顺序的最大值：jyl
//        2. Object max(Collection, Comparator):根据 Comparator 指定的顺序，返回给定集合中的最大元素
        //比如我要长度最大的
        Object max = Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最大的值为：" + max);//长度最大的值为：abba
//        3. Object min(Collection)
//        System.out.println("自然顺序的最小值：" + Collections.min(list));//自然顺序的最小值：abba
//        4. Object min(Collection, Comparator)
        //比如我要长度最小的
        Object min = Collections.min(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        System.out.println("长度最小的值为：" + min);//长度最小的值为：cx
//        5. int frequency(Collection,Object):返回指定集合中指定元素的出现次数
        System.out.println("cx出现的次数为：" + Collections.frequency(list, "cx"));//cx出现的次数为：1
//        6. void copy(List dest,List src):将src中的内容复制到dest中
        ArrayList dest = new ArrayList();
        //为了完成复制，必须先让dest的size和list.size一样
        for (int i = 0; i < list.size(); i++) {
            dest.add("");
        }
        Collections.copy(dest, list);
        System.out.println("dest = " + dest);
//        7. boolean replaceAll(List list, Object oldVal, Object newVal):使用新值替换List对象的所有旧值
        Collections.replaceAll(list, "abba", "Disco");
        System.out.println("list被替换后：" + list);//list被替换后：[jyl, cx, Disco, babo]


    }
}
