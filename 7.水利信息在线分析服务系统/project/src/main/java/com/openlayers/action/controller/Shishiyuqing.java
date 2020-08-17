package com.openlayers.action.controller;

import com.openlayers.action.dao.St_soil_rDao;
import com.openlayers.action.entity.St_soil_r;
import com.openlayers.action.entity.YuliangStatisticInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class Shishiyuqing {

    @Resource
    private St_soil_rDao st_soil_rDao;

    //网页显示所有雨量信息
    @RequestMapping("/yuliangxinxi")
    @ResponseBody
    public List<St_soil_r> yuliangxinxi(){
        return st_soil_rDao.findAll();
    }


    @RequestMapping("/zuidayuliang")
    @ResponseBody
    public List<St_soil_r> zuidayuliang(){
        return st_soil_rDao.findMaxYuliang();
    }

    @RequestMapping("/yuliangtongji")
    @ResponseBody
    public List<YuliangStatisticInfo> yuliangtongji(){
        return st_soil_rDao.findStatisticsInfo();
    }


}
