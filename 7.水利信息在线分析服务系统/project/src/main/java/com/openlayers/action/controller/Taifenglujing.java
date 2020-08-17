package com.openlayers.action.controller;

import com.openlayers.action.dao.Wind_basicInfoDao;
import com.openlayers.action.dao.Wind_infoDao;
import com.openlayers.action.entity.Wind_basicInfo;
import com.openlayers.action.entity.Wind_info;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Taifenglujing {

    @Resource
    private Wind_basicInfoDao wind_basicInfoDao;

    @Resource
    private Wind_infoDao wind_infoDao;


    //从台风基本信息表中查询台风基本数据
    @RequestMapping("/findWind_basicInfo")
    @ResponseBody
    public List<Wind_basicInfo> findWind_basicInfo(){
        List<Wind_basicInfo> wind_basicInfoList = wind_basicInfoDao.findAll();
        return wind_basicInfoList;
    }



    //从台风详细信息表中查询时间、风力和风速
    @ResponseBody
    @RequestMapping("/tmWindStrongWindspeed")
    public List<Wind_info> findTmWindStrongWindspeed(){
        List<Wind_info> tmWindStrongWindspeed = wind_infoDao.findTmWindStrongWindspeed();
        return tmWindStrongWindspeed;
    }


}
