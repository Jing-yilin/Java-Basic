package com.hspedu.customgeneric;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Homework01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2022/1/20 14:31
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Homework01 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("11521", new User(1, 16, "Jack"));
        userDAO.get("11521");
        userDAO.update("11521", new User(2, 18, "Mary"));
        System.out.println(userDAO.list());
        userDAO.delete("11521");
    }

    @Test
    public void test1(){
        DAO<User> userDAO = new DAO<User>();
        userDAO.save("11521", new User(1, 16, "Jack"));
        userDAO.get("11521");
        userDAO.update("11521", new User(2, 18, "Mary"));
        System.out.println(userDAO.list());
        userDAO.delete("11521");
    }
}

@SuppressWarnings("all")
class DAO<T>{
    public Map map = new HashMap<String, T>();

    public DAO() {
    }

    public void save (String id, T entity){
        if (map.containsKey(id)) {
            System.out.println("此id已存在，请使用update!");
            return;
        }
        map.put(id, entity);
    }

    public T get(String id){
        if (!map.containsKey(id)) {
            System.out.println("此id不存在！返回值为null！");
            return null;
        }
        return (T)map.get(id);
    }

    public void update(String id, T entity){
        if (!map.containsKey(id)) {
            System.out.println("此id不存在！");
            return;
        }
        map.put(id, entity);
    }

    public List<T> list(){
        Collection values = map.values();
        List<T> ts = new ArrayList<>();
        for(Object obj: values){
            ts.add((T)obj);
        }
        return ts;
    }

    public void delete(String id) {
        if (!map.containsKey(id)) {
            System.out.println("此id不存在！");
            return;
        }
        map.remove(id);
        System.out.println("删除成功！");
    }
}

class User {
    private int id, age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
