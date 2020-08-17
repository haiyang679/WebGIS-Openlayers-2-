package com.openlayers.action.MybatisTest.daoTest;

import com.openlayers.action.dao.St_soil_rDao;
import com.openlayers.action.entity.St_soil_r;
import com.openlayers.action.entity.YuliangStatisticInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class St_soil_rTest {

    @Autowired
    private St_soil_rDao st_soil_rDao;

    //测试查询所有雨晴
    @Test
    public void testFindAll(){
        List<St_soil_r> st_soil_rList = st_soil_rDao.findAll();
        for(St_soil_r st_soil_r : st_soil_rList){
            System.out.println(st_soil_r);
        }
    }

    //测试查询各个站点最大雨晴
    @Test
    public void testFindMaxYuliang(){
        List<St_soil_r> st_soil_rList = st_soil_rDao.findMaxYuliang();
        for(St_soil_r st_soil_r : st_soil_rList){
            System.out.println(st_soil_r);
        }
    }

    @Test
    public void testFindStatisticsInfo(){
        List<YuliangStatisticInfo> statisticsInfo = st_soil_rDao.findStatisticsInfo();
        for(YuliangStatisticInfo yuliangStatisticInfo: statisticsInfo){
            System.out.println(yuliangStatisticInfo.toString());

        }

    }
}
