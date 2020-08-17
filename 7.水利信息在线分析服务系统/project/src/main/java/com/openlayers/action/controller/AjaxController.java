package com.openlayers.action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AjaxController {

    @RequestMapping("/login")
    @ResponseBody
    public Map nameAddPassword(@RequestParam("name") String name,
                               @RequestParam("password") String password){
        //改造输入的数据
        System.out.println(name);
        System.out.println(password);
        name = "姜雪婷";
        password ="147258";
        Map map = new HashMap();
        map.put("newName",name);
        map.put("newPassword",password);
        return map;
    }

    @RequestMapping("/user")
    public String ajaxHtml(){
        return "Ajax1";
    }

}
