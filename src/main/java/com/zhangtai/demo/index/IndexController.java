package com.zhangtai.demo.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("slogan", "智慧建筑方案提供商");
		return "index";
	}

}
