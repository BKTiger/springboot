package com.zhangtai.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

// 实现类里的RequestMapping会覆盖父类
@RequestMapping("base")
public abstract class BaseController{
    protected final static String base_url = "base";

    @RequestMapping("/getAll") //有实现类后该方法可以访问到
    public String getAll(){
        return "test";
    }

    // 实现该方法的类,可以通过该路径访问
    // 实现该方法的RequestMapping会覆盖抽象方法里的
    @RequestMapping("/getOne")
    public abstract String getOne();
}
