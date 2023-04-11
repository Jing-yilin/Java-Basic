package getter_setter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/15:24
 * @Description:
 */
public class TestPerson {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Yoshiki");
        p.setAge(-1);

//        p.eat();
        System.out.println(p.getName());
    }

}
