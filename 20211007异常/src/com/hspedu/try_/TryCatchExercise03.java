package com.hspedu.try_;

/**
 * @ClassName TryCatchExercise03
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 9:20
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class TryCatchExercise03 {
    public static int method(){
        int i = 1;//1
        try{
            i++;//2
            String[] names = new String[3];
            if(names[1].equals("tom")){//NullPointerException
                System.out.println(names[1]);
            } else{
                names[3] = "hspedu";
            }
            return 1;
        }
        catch (ArrayIndexOutOfBoundsException e){
            return 2;
        }
        catch (NullPointerException e){
            //返回3
            return ++i;//3
        }
        finally{
            ++i;//4
            System.out.println("i = " + i);//i = 4
        }
    }

    public static void main(String[] args) {
        System.out.println(method());//3
    }
}
