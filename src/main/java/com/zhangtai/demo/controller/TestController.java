package com.zhangtai.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseController.base_url + "base2")
public class TestController extends BaseController{
    

    @RequestMapping("getOne2")
    @Override
    public String getOne() {
        return "test one";
    }
}
