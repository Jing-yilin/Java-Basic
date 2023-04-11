# Class类

![image-20220209113616489](https://s2.loli.net/2022/02/09/U6eLKjz358EP1nm.png)

1. Class也是类，因此也继承Object类[类图]

2. Class类对象不是new出来的，而是系统创建的

   ```java
   public Class<?> loadClass(String name) throws ClassNotFoundException {
       return loadClass(name, false);
   }
   ```

3. 对于某个类的Class类对象，在内存中只有一份，因为类只加载一次

4. 每个类的实例都会记得自己是由哪个Class实例所生成

5. 通过Class可以完整地得到一个类的完整结构，通过一系列API

6. Class对象是存放在堆的

7. 类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据（包括方法代码，变量名，方法名，访问权限等等）https://www.zhihu.com/question/38496907

## 方法演示

```java
String classFullPath = "com.hspedu.Car";
//1. 获取Car类对应的class对象
//<?>表示不确定的Java类型
Class<?> cls = Class.forName(classFullPath);
//2. 输出cls
System.out.println(cls);//class com.hspedu.Car
System.out.println( cls.getClass());//class java.lang.Class
//3. 得到包名
System.out.println(cls.getPackage().getName());//com.hspedu
//4. 得到类名
System.out.println(cls.getName());//com.hspedu.Car
//5. 通过cls创建对象实例
Object o = cls.newInstance();
System.out.println(o);//Car{brand='BMW', price=500000, color='white'}
//6. 通过反射获取属性
Field brand = cls.getField("brand");
System.out.println(brand.get(o));//BMW
//7. 通过反射给属性赋值
brand.set(o, "奔驰");
System.out.println(brand.get(o));//奔驰
//8. 拿到所有的字段属性
Field[] fields = cls.getFields();
for (int i = 0; i < fields.length; i++) {
    System.out.print(fields[i] + "\t");//public java.lang.String com.hspedu.Car.brand  public int com.hspedu.Car.price    public java.lang.String com.hspedu.Car.color
}
```

## 获取Class类对象

1. 已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法`forName()`获取，可能抛出`ClassNotFoundException`

```java
//1. Class.forName()
String classFullPath = "com.hspedu.Car";
Class<?> cls = Class.forName(classFullPath);
```

2. 若已知具体的类，通过类的class获取，改方式最为安全可靠，程序性能最高，多用于参数的传递

```java
//2. 类名.class
Class<Car> carClass = Car.class;
System.out.println(carClass);//class com.hspedu.Car
```

3. 如果已经知道某个类的实例了，调用该实例的`getClass()`方法获取Class对象

```java
//3. 实例.getClass
Car car = new Car();
System.out.println(car.getClass());//class com.hspedu.Car
```

4. 通过类加载器`ClassLoader`[有四种，比较复杂]获取

```java
//4. 通过类加载器获取
//(1) 先得到Cat的类加载器
ClassLoader classLoader = car.getClass().getClassLoader();
//(2) 通过类加载器得到Class对象
Class<?> cls4 = classLoader.loadClass(classFullPath);
System.out.println(cls4);//class com.hspedu.Car
```

5. 基本数据类型(int, char, boolean, float, double, byte, long, short)

```java
//5. 基本数据类型(int, char, boolean, float, double, byte, long, short)
Class<Integer> integerClass = int.class;
Class<Character> characterClass = char.class;
Class<Boolean> booleanClass = boolean.class;
System.out.println(integerClass);//int
System.out.println(characterClass);//char
System.out.println(booleanClass);//boolean
```

6. 基本数据类型对应的包装类，可以通过 .TYPE 得到Class对象

```java
Class<Integer> integerType = Integer.TYPE;
System.out.println(integerType);//int
```

7. 其他

```java
Class<String> stringClass = String.class;//外部类
Class<Serializable> serializableClass = Serializable.class;//接口
Class<Integer[]> aClass1 = Integer[].class;//一维数组
Class<Integer[][]> aClass2 = Integer[][].class;//二位数组
Class<Integer[][][]> aClass3 = Integer[][][].class;//三维数组
Class<Deprecated> deprecatedClass = Deprecated.class;//注解
Class<Thread.State> stateClass = Thread.State.class;//枚举
Class<Long> longClass = long.class;
Class<Void> voidClass = void.class;//void
Class<Class> classClass = Class.class;//Class类的class对象
```

