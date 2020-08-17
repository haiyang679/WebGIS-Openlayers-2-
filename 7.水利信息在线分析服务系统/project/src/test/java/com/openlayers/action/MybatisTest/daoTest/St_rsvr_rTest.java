package com.openlayers.action.MybatisTest.daoTest;

import com.openlayers.action.dao.St_rsvr_rDao;
import com.openlayers.action.entity.St_rsvr_r;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class St_rsvr_rTest {

    @Autowired
    private St_rsvr_rDao st_rsvr_rDao;

    //测试查询所有水库信息
    @Test
    public void testFindAll() {
        List<St_rsvr_r> st_rsvr_rDaoList = st_rsvr_rDao.findAll();
       for(St_rsvr_r st_rsvr_r : st_rsvr_rDaoList){
           System.out.println(st_rsvr_r);
       }
    }

    //根据站码查询水库信息
    @Test
    public void testFindSt_rsvr_rByZhanma(){
        List<St_rsvr_r> st_rsvr_rByZhanma = st_rsvr_rDao.findSt_rsvr_rByZhanma("61100500");
        for(St_rsvr_r st_rsvr_r:st_rsvr_rByZhanma){
            System.out.println(st_rsvr_r);
        }
    }
}
