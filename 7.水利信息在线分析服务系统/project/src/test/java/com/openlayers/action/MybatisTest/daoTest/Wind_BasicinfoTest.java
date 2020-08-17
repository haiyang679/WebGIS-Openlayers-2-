package com.openlayers.action.MybatisTest.daoTest;


import com.openlayers.action.dao.Wind_basicInfoDao;
import com.openlayers.action.entity.Wind_basicInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Wind_BasicinfoTest {

    @Autowired
    private Wind_basicInfoDao wind_basicInfoDao;

    @Test
    public void testFindAll(){

        List<Wind_basicInfo> wind_basicInfoDaoList = wind_basicInfoDao.findAll();
        for (Wind_basicInfo wind_basicInfo : wind_basicInfoDaoList){
            System.out.println(wind_basicInfo);
        }
    }

}
