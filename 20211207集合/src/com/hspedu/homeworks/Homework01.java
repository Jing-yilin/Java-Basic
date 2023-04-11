package com.hspedu.homeworks;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/19 18:55
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework01 {
    public static void main(String[] args) {
        News n1 = new News("新冠确诊病例超干万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        n1.setContent("新冠确诊病例超干万，数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News n2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        n2.setContent("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList arrayList = new ArrayList();
        arrayList.add(n1);
        arrayList.add(n2);
        //进行倒叙遍历
//        Collections.reverse(arrayList);
//        Iterator iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            News next = (News)iterator.next();
//            String title = next.getTitle();
//            if(title.length() > 15)
//            {
//                next.setTitle(title.substring(0,16)+"...");
//            }
//            System.out.println(next);
//        }

        //老韩写的倒序遍历
        int size = arrayList.size();
        for (int i = size-1; i >= 0; i--) {
            News n = (News)arrayList.get(i);
            System.out.println(processTitle(n.getTitle()));
        }

    }

    //专门写一个方法处理标题
    public static String processTitle (String title){
        if(title == null){
            return "";
        }
        int length = title.length();
        if(length <= 15)
            return title;
        else
            return title.substring(0, 15)+"...";
    }
}

class News {
    private String title;
    private String Content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title +
                '}';
    }
}
