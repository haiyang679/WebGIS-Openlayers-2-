package com.openlayers.senior.mapController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @RequestMapping("/AddTextandPic")
    public String addTextandPic(){
        return "AddTextandPic";
    }

    @RequestMapping("/AddPopup")
    public String addPopup(){
        return "AddPopup";
    }

}
