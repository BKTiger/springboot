package com.zhangtai.demo.index;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("slogan", "智慧建筑方案提供商");
		return "index";
	}

}
