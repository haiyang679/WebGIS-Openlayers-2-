package com.openlayers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MapController {

    //使用openlayers调用arcgis server 的瓦片地图服务
    @RequestMapping("/TileArcGIS")
    public String tileArcgisServer(){
        return "TileArcGIS";
    }


    //使用openlayers的ol.layer.Image  调用arcgis sever发布的动态服务
    @RequestMapping("/DynamicArcGISREST")
    public String dynamicArcGISREST(){
        return "DynamicArcGISREST";
    }

    //使用openlayers加载arcgis online地图
    @RequestMapping("/ImageArcGIS")
    public String imageArcGIS(){
        return "ImageArcGIS";
    }

    //加载GeoJson数据
    @RequestMapping("/GeoJson")
    public String geoJson(){
        return "GeoJson";
    }

    //加载KML数据
    @RequestMapping("/KML")
    public String kML(){
        return "KML";
    }

    //加载GPX数据
    @RequestMapping("/GPX")
    public String gPX(){
        return "gpx";
    }

    //加载OSM地图
    @RequestMapping("/OSM")
    public String oSM(){
        return "OSM";
    }
    //加载OSM地图
    @RequestMapping("/Bing")
    public String bing(){
        return "Bing";
    }
    //加载天地图
    @RequestMapping("/TiandituMap")
    public String tiandituMap(){
        return "TiandituMap";
    }


}
