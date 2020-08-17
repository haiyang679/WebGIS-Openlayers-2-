package com.openlayers.action.MybatisTest.daoTest;


import com.openlayers.action.dao.St_river_rDao;
import com.openlayers.action.entity.St_river_r;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class St_river_rTest {

    @Autowired
    private St_river_rDao st_river_rDao;

    @Test
    public void testFindAll(){
        List<St_river_r> st_river_rList = st_river_rDao.findAll();
        for(St_river_r st_river_r : st_river_rList){
            System.out.println(st_river_r);
        }
    }

    @Test
    public void testFindSt_river_rByZhanma(){
        List<St_river_r> st_river_rByZhanma = st_river_rDao.findSt_river_rByZhanma("61100700");
        for (St_river_r st_river_r:st_river_rByZhanma){
            System.out.println(st_river_r);
        }
    }
}
