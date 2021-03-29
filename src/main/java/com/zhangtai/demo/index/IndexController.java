package com.zhangtai.demo.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
public class IndexController {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("/")
    public String showIndex(Model model, HttpServletResponse response, HttpServletRequest request) {

        model.addAttribute("slogan", "智慧建筑方案提供商");

        IndexEvent indexEvent = new IndexEvent("11111");
        applicationContext.publishEvent(indexEvent);//利用spring的事件机制
        return "index";
    }

    @RequestMapping("/test_converter")
    @ResponseBody
    public String showIndex(@RequestParam Date day, @RequestParam String day1) {
        System.out.println(day);
        System.out.println(day1);
		return "index";
    }

}
