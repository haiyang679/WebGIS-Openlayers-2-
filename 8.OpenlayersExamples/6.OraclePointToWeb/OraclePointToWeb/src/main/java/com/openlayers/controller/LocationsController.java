package com.openlayers.controller;

import com.openlayers.dao.LocationsDao;
import com.openlayers.entity.Locations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LocationsController {

    @Resource
    private LocationsDao locationsDao;

    @ResponseBody
    @RequestMapping("/queryLocations")
    public List<Locations> findAllLocations(){
        return locationsDao.findAllLocations();
    }

}
