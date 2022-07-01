package com.cn.java.controller;

import com.cn.java.service.menu.MenuService;
import com.cn.java.util.TableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Menu")
public class MenuController {
    @Autowired
    private MenuService m;
    @RequestMapping("toWelcome")
    public String toWelcome(){
        return "/layui/welcome";
    }
    @RequestMapping("toMenu")
    public String toMenu(){
        return "/layui/menu";
    }
    @RequestMapping("toMenu1")
    @ResponseBody
    public TableData toMenu1(){
        return m.selectAll();
    }
}
