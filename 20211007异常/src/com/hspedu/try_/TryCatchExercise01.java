package com.hspedu.try_;

/**
 * @ClassName TryCatchExercise01
 * @Description TODO
 * @Author Jing Yilin
 * @Date 2021/10/7 9:07
 * @Version 1.0
 **/
public class TryCatchExercise01 {
    public static int method(){
        try{
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
            return 3;
        }
        //由于finally必须执行，则一定返回4
        finally{
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}
