package com.hspedu.customgeneric;

@SuppressWarnings("all")
public interface IUsb<U, R> {
    int n = 10;
    //U name;//不能这么使用

    //普通方法中，可以使用泛型接口
    R get (U u);

    void hi (R r);

    //jdk8中，可以在接口中，使用默认方法，也可以使用泛型
    default R method(U u)
    {
        return null;
    }
    //私有方法也可以使用泛型
    private R m1 (U u){
        return null;
    }
}

interface IA extends IUsb<String, Double>{

}

class X {
    public static void main(String[] args) {
        IA ia = new IA(){
            @Override
            public Double get(String s) {
                return null;
            }

            @Override
            public void hi(Double aDouble) {

            }
        };

        System.out.println(ia.n);
        ia.method("hello");
    }
}
