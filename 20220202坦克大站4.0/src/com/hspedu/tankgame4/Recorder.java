package com.hspedu.tankgame4;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

/**
 * @ClassName Recorder
 * @Description 一个线程，每个5秒记录所有敌方坦克的位置坐标
 * @Author Jing Yilin
 * @Date 2022/2/2 10:57
 * @Version 1.0
 **/
@SuppressWarnings("all")
public class Recorder implements Runnable {

    //记录我方击毁敌方坦克总数
    public static int destroyedJokerNum = 0;

    public static Vector<Joker> jokers = null;
    public static Hero hero = null;

    //定义IO对象
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static String fileName = "src\\jokerInfo.properties";


    public static Vector<Joker> getJokers() {
        return jokers;
    }

    public static void setJokers(Vector<Joker> jokers) {
        Recorder.jokers = jokers;
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        System.out.println("hero传入了Recorder");
        Recorder.hero = hero;
    }

    public static void addDestroyedJokerNum() {
        Recorder.destroyedJokerNum++;
    }

    /**
     * 记录击毁敌人数、存活敌人数、所有敌人位置坐标
     *
     * @throws IOException
     */
    public static void storeInfo() throws IOException {
        if (jokers == null)
            System.out.println("joker == null");
        if (hero == null)
            System.out.println("hero == null");
        if (jokers != null && hero != null) {
            Properties properties = new Properties();
            properties.setProperty("heroX", new Integer(hero.x).toString());
            properties.setProperty("heroY", new Integer(hero.y).toString());
            properties.setProperty("heroDirect", new Integer(hero.y).toString());
            properties.setProperty("destroyedJokerNum", new Integer(destroyedJokerNum).toString());
            properties.setProperty("jokerNum", new Integer(jokers.size()).toString());
            for (int i = 0; i < jokers.size(); i++) {
                Joker joker = jokers.get(i);
                properties.setProperty("x" + i, new Integer(joker.x).toString());
                properties.setProperty("y" + i, new Integer(joker.y).toString());
                properties.setProperty("direct" + i, new Integer(joker.direct).toString());
                properties.store(new FileOutputStream(fileName), "Info of jokers");
            }
            System.out.println("存档成功！");
        }
    }

    public static void readRecord() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            hero.setX(Integer.parseInt(properties.getProperty("heroX")));
            hero.setY(Integer.parseInt(properties.getProperty("heroY")));
            hero.setDirect(Integer.parseInt(properties.getProperty("heroDirect")));
            System.out.println("hero信息恢复存档");
            Recorder.destroyedJokerNum = Integer.parseInt(properties.getProperty("destroyedJokerNum"));
            for (int i = 0; i < Integer.parseInt(properties.getProperty("jokerNum")); i++) {
                jokers.add(new Joker(Integer.parseInt(properties.getProperty("x" + i)),
                        Integer.parseInt(properties.getProperty("y" + i)),
                        Integer.parseInt(properties.getProperty("direct" + i))));
            }
            System.out.println("存档读取成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                storeInfo();
//                System.out.println("自动存档成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
