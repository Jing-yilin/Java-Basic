package toString;

import javax.swing.plaf.synth.ColorType;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/14/5:51
 * @Description:
 */
public class Cat {

    String name;
    String color;

    public Cat(String name, String color){
        this.name = name;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cat c = new Cat("小花", "绿色");

        System.out.println(c);
        System.out.println(c.toString());
    }
}
