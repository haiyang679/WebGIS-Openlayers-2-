package com.openlayers.action.MybatisTest.daoTest;

import com.openlayers.action.dao.Wind_infoDao;
import com.openlayers.action.entity.Wind_info;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Wind_infoTest {

    @Autowired
    private Wind_infoDao wind_infoDao;

    @Test
    public void testFindAll(){
        List<Wind_info> wind_infoList = wind_infoDao.findAll();
        for(Wind_info wind_info : wind_infoList){
            System.out.println(wind_info);
        }
    }

    @Test
    public void testFindTmWindStrongWindspeed(){
        List<Wind_info> tmWindStrongWindspeed = wind_infoDao.findTmWindStrongWindspeed();
        for(Wind_info wind_info:tmWindStrongWindspeed){
            System.out.println(wind_info);
        }
    }
}
