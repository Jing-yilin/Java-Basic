package com.hspedu.reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionUtils
 * @Description 演示通过反射获取类的结构信息
 * @Author Jing Yilin
 * @Date 2022/2/9 14:06
 * @Version 1.0
 **/
public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    @SuppressWarnings("all")
    public void api_01() throws Exception{
        Class<?> personClass = Class.forName("com.hspedu.reflection.Person");
        //1. getName:获取全类名
        System.out.println("1. getName:获取全类名");
        System.out.println(personClass.getName());
        //2. getSimpleName:获取简单类名
        System.out.println("2. getSimpleName:获取简单类名");
        System.out.println(personClass.getSimpleName());
        //3. getFields:获取所有public修饰的属性，包含本类以及父类的
        System.out.println("3. getFields:获取所有public修饰的属性，包含本类以及父类的");
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.print(field.getName() + "\t");
        }
        System.out.println();
        //4. getDeclaredFields:获取本类中所有属性
        System.out.println("4. getDeclaredFields:获取本类中所有属性");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(declaredField.getName() + "\t");
        }
        System.out.println();
        //5. getMethods:获取所有public修饰的方法，包含本类以及父类的
        System.out.println("5. getMethods:获取所有public修饰的方法，包含本类以及父类的");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "\t");
        }
        System.out.println();
        //6. getDeclaredMethods:获取本类中所有方法
        System.out.println("6. getDeclaredMethods:获取本类中所有方法");
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + "\t");
        }
        System.out.println();
        //7. getConstructors:获取所有public修饰的构造器，包含本类以及父类的
        System.out.println("7. getConstructors:获取所有public修饰的构造器，包含本类以及父类的");
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.print(constructor.getName() + "\t");
        }
        System.out.println();
        //8. getDeclaredConstructors:获取本类中所有构造器
        System.out.println("8. getDeclaredConstructors:获取本类中所有构造器");
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.print(declaredConstructor.getName() + "\t");
        }
        System.out.println();
        //9. getPackage:以Package形式返回 包信息
        System.out.println("9. getPackage:以Package形式返回 包信息");
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage.getName());
        //10. getSuperClass:以Class形式返回父类信息
        System.out.println("10. getSuperClass:以Class形式返回父类信息");
        Class<?> superclass = personClass.getSuperclass();
        System.out.println(superclass.getName());
        //11. getInterfaces:以Class[]形式返回接口信息
        System.out.println("11. getInterfaces:以Class[]形式返回接口信息");
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.print(anInterface.getName() + "\t");
        }
        System.out.println();
        //12. getAnnotations:以Annotation[]形式返回注解信息
        System.out.println("12. getAnnotations:以Annotation[]形式返回注解信息");
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.print(annotation+ "\t");
        }
        System.out.println();
    }

    @Test
    public void api_02() throws Exception{
        Class<?> personClass = Class.forName("com.hspedu.reflection.Person");

        //1. getModifiers:以int形式返回修饰符
        System.out.println("1. getModifiers:以int形式返回修饰符");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " 属性的修饰符 = "+ declaredField.getModifiers());
        }
        /**
         * name 属性的修饰符 = 1
         * age 属性的修饰符 = 4
         * job 属性的修饰符 = 0
         * sal 属性的修饰符 = 2
         */

        //2. getType:以Class形式返回类型
        System.out.println("2. getType:以Class形式返回类型");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " 类型 = "+ declaredField.getType());
        }

        //3. getName:返回属性名
        System.out.println("3. getName:返回属性名");

    }

    @Test
    public void api_03() throws Exception{
        Class<?> personClass = Class.forName("com.hspedu.reflection.Person");
        Method[] declaredMethods = personClass.getDeclaredMethods();

        //1. getModifiers:以int形式返回修饰符
        System.out.println("1. getModifiers:以int形式返回修饰符");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + "的修饰符 = " + declaredMethod.getModifiers());
        }

        //2. getReturnType:以Class形式获取返回类型
        System.out.println("2. getReturnType:以Class形式获取返回类型");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName() + "方法的返回类型为 = " + declaredMethod.getReturnType());
        }

        //3. getName:返回方法名
        System.out.println("3. getName:返回方法名");
        System.out.println();

        //4. getParameterTypes:以Class[]返回参数类型数组
        System.out.println("4. getParameterTypes:以Class[]返回参数类型数组");
        for (Method declaredMethod : declaredMethods) {
            System.out.print(declaredMethod.getName() + "方法的形参类型 = ");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.print(parameterType + "\t");
            }
            System.out.println();
        }


    }
}

@Deprecated
class Person extends FatherPerson implements Banana{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person(){

    }

    public void m1(String name){

    }
    protected double m2(double sal){
        return 1.0;
    }
    void m3(){

    }
    private void m4(){

    }

}

class FatherPerson{
    public String hobby;

    public FatherPerson(){

    }

    public void hi(){};
}

interface Banana{

}
