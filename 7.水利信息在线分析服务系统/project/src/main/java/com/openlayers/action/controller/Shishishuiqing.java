package com.openlayers.action.controller;

import com.openlayers.action.dao.St_river_rDao;
import com.openlayers.action.dao.St_rsvr_rDao;
import com.openlayers.action.entity.St_river_r;
import com.openlayers.action.entity.St_rsvr_r;
import com.openlayers.action.service.St_rsvr_rService.St_rsvr_rService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class Shishishuiqing {

    @Resource
    private St_rsvr_rService st_rsvr_rService;

    @Resource
    private St_river_rDao st_river_rDao;

    @Resource
    private St_rsvr_rDao st_rsvr_rDao;

    @RequestMapping("/shuiku")
    @ResponseBody
    public List<St_rsvr_r> shuiku(){
        List<St_rsvr_r> st_rsvr_rList = st_rsvr_rService.findSt_rsvr_r();
        return st_rsvr_rList;
    }


    @RequestMapping("/river")
    @ResponseBody
    public List<St_river_r> river(){
        return st_river_rDao.findAll();
    }

    @RequestMapping("/shuiku/{zhanma}")
    @ResponseBody
    public List<St_rsvr_r> findSt_rsvr_rByZhanma(@PathVariable("zhanma") String zhanma){
        return st_rsvr_rDao.findSt_rsvr_rByZhanma(zhanma);
    }

    @RequestMapping("/river/{zhanma}")
    @ResponseBody
    public List<St_river_r> findSt_river_rByZhanma(@PathVariable("zhanma") String zhanma){
        return st_river_rDao.findSt_river_rByZhanma(zhanma);

    }
}
