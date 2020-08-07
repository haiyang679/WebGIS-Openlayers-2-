package com.openlayers.quickstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @RequestMapping("/TiandituMap")
    public String tiandituMap(){
        return "TiandituMap";
    }

    @RequestMapping("/ZoomSlider")
    public String zoomSlider(){
        return "ZoomSlider";
    }

    @RequestMapping("/Operation")
    public String operation(){
        return "Operation";
    }

    @RequestMapping("/MousePosition")
    public String mousePosition(){
        return "MousePosition";
    }

    @RequestMapping("/ScaleLine")
    public String scaleLine(){
        return "ScaleLine";
    }

    @RequestMapping("/OverViewMap")
    public String overViewMap(){
        return "OverViewMap";
    }

    @RequestMapping("/FullScreen")
    public String fullScreen(){
        return "FullScreen";
    }

    @RequestMapping("/LayerControl")
    public String layerControl(){
        return "LayerControl";
    }

}
