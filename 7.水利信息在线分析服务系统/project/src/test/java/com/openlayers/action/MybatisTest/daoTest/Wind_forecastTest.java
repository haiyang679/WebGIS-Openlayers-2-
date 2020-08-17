package com.openlayers.action.MybatisTest.daoTest;

import com.openlayers.action.dao.Wind_forecastDao;
import com.openlayers.action.entity.Wind_forecast;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Wind_forecastTest {

    @Autowired
    private Wind_forecastDao wind_forecastDao;

    @Test
    public void testFindAll(){
        List<Wind_forecast> wind_forecastList = wind_forecastDao.findAll();
        for (Wind_forecast wind_forecast : wind_forecastList){
            System.out.println(wind_forecast);
        }
    }
}
