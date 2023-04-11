package getter_setter;

public class Person {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    public void eat() {
//    System.out.println(this.name + "吃东西!");
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setAge(int age) {
//        if (age < 0) {
//            this.age = 0;
//        }else {
//            this.age = age;
//        }
//    }
//
//    public String getName()
//    {
//        return this.name;
//    }

}
