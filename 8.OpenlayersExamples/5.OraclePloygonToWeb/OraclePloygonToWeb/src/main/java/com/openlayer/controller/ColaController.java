package com.openlayer.controller;

import com.openlayer.dao.ColaDao;
import com.openlayer.entity.ColaMarket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
public class ColaController {

    @Resource
    private ColaDao colaDao;
    @GetMapping("/queryColaMarket")
    public List<ColaMarket> queryColaMarket(){
        return  colaDao.findAll();
    }
}
