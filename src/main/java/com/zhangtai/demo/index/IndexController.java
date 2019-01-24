package com.zhangtai.demo.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String showIndex(Model model, HttpServletResponse response, HttpServletRequest request){

		model.addAttribute("slogan", "智慧建筑方案提供商");
		return "index";
	}

}
