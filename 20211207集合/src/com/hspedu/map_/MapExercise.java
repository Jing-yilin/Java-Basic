package com.hspedu.map_;

import java.util.*;

@SuppressWarnings("all")
/**
 * @ClassName MapExercise
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/12/21 23:54
 * @Version 1.0
 **/
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        Staff staff1 = new Staff("jyl", 18001);
        Staff staff2 = new Staff("jfm", 1231);
        Staff staff3 = new Staff("zephyr", 99999);
        map.put(staff1.getId(), staff1);
        map.put(staff2.getId(), staff2);
        map.put(staff3.getId(), staff3);

        //遍历显示工资>18000的员工
        //方法一
        Collection values = map.values();
        for (Object o : values)
        {
            Staff staff = (Staff) o;
            if (staff.getSal() > 18000)
            {
                System.out.println(staff);
            }
        }
        //方法二
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Staff staff = (Staff) entry.getValue();
            if (staff.getSal() > 18000)
            {
                System.out.println(staff);
            }
        }
//        for(Object entry : entrySet)
//        {
//            Map.Entry m = (Map.Entry) entry;
//            Staff staff = (Staff) m.getKey();
//            if (staff.getSal() > 18000)
//            {
//                System.out.println(staff);
//            }
//        }

    }
}
class Staff {
    private String name;
    private int sal;
    private int id;
    private static int count = 0;

    public Staff(String name, int sal) {
        this.name = name;
        this.sal = sal;
        count++;
        id = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
