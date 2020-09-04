package com.selectfeature.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SelectFeaturesToJavaController {

    @PostMapping("/featureToJava")
    @ResponseBody
    public String featureToJava(@RequestBody String data) throws JSONException, JSONException {
        //System.out.println(data);
        //将字符串转换成json对象
        JSONObject jsonObject = new JSONObject(data);

        //拿到json对象中key为name的数据，，为string类型
        String name = jsonObject.getString("name");
        System.out.println(name);

        //拿到json对象中key为coord的数据，，为数组类型
        JSONArray coord = jsonObject.getJSONArray("coord");
        for (int i = 0;i<coord.length();i++){
            Double x = (Double) coord.get(i);  //数组下标为偶数，对应x  小数点前七位数
            Double y = (Double)coord.get(++i);  //数组下标为奇数，对于y  小数点前为6位
            //将web墨卡托投影转换位经纬度
            List lonLat = mercator2LonLat(x, y);
            System.out.println(lonLat);
        }

        //System.out.println(lon);
        //System.out.println(coord.toString());
        //System.out.println(coord);
        return "hello";
    }

    /**
     * web墨卡托 转 WGS-84，主要用于将坐标单位为米的值转为单位为度的值
     * @param {double} mercatorX X坐标
     * @param {double} mercatorY Y坐标
     * @author zjh 2018-08-23
     */
    public List<Double> mercator2LonLat(Double mercatorX, Double mercatorY) {
        Double lon =  mercatorX * 180 / 20037508.34;
        Double lat = (180 / Math.PI * (2 * Math.atan(Math.exp((mercatorY / 20037508.34) * Math.PI)) - Math.PI / 2));
        List<Double> list = new ArrayList();
        list.add(lat);
        list.add(lon);
        return list;
    }


}
