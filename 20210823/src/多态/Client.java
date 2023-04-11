package 多态;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 景风眠
 * @Date: 2021/08/13/16:34
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
//        Cat c = new Cat();
//        Dog d = new Dog();
        Person p = new Person();
//        p.feedCat(c);
//        p.feedDog(d);

        Animal c_1 = new Cat();
        Animal d_1 = new Dog();
        p.feedAnimal(c_1);
        p.feedAnimal(d_1);
    }
}
