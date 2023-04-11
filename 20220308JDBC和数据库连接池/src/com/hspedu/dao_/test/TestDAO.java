package com.hspedu.dao_.test;

import com.hspedu.dao_.dao.ActorDAO;
import com.hspedu.dao_.dao.GoodsDAO;
import com.hspedu.dao_.domain.Actor;
import com.hspedu.dao_.domain.Goods;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @ClassName TestDAO
 * @Description 测试ActorDAO的 CRUD 操作
 * @Author zephyr
 * @Date 2022/5/25 20:28
 * @Version 1.0
 */
public class TestDAO {
    @Test
    public void testActorDAO(){
        ActorDAO actorDAO = new ActorDAO();
        //1. 查询多行多列
        List<Actor> actors = actorDAO.queryMulti("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("====查询多行多列结果====");
        for (Actor actor: actors){
            System.out.println(actor);
        }

        //2. 查询单行记录
        Actor actor1 = actorDAO.querySingle("select * from actor where name = ?", Actor.class, "毛毛");
        System.out.println("====查询单行结果====");
        System.out.println(actor1);

        //3. 查询单行单列值
        Object o = actorDAO.queryScalar("select borndate from actor where name = ?", "毛毛");
        System.out.println("====查询单行单列结果====");
        System.out.println(o);

        //4. dml操作 insert,update,delete
        int update = actorDAO.update("insert into actor values (null, ?, ?, ?, ?)", "Yoshiki", "男", "1976-01-02", "999");
        System.out.println(update > 0 ? "执行成功":"未影响表格");


    }

    /*
    课后作业，通过DAO完成对goods表的CRUD
     */
    @Test
    public void testGoodsDAO(){
        GoodsDAO goodsDAO = new GoodsDAO();
        //查询所有记录
        List<Goods> goodsList = goodsDAO.queryMulti("select * from goods", Goods.class);
        for (Goods goods: goodsList){
            System.out.println(goods);
        }
        //插入一条记录
        int update = goodsDAO.update("insert into goods values(null, '抹茶冰淇淋', 281)");
        System.out.println("一共影响了" + update + "行");
    }
}
