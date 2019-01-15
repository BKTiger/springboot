package com.zhangtai.demo.index.controller;

import com.github.pagehelper.Page;
import com.zhangtai.demo.index.domain.Student;
import com.zhangtai.demo.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
	@Autowired
	private IndexService indexService;

	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("slogan", "智慧建筑方案提供商");
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "/getById",method = RequestMethod.GET)
	public Student getById(Model model, @RequestParam Map<String,Object> param){
		return indexService.getById(param.get("id").toString());
	}

	@ResponseBody
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public Page<Student> page(Model model, @RequestParam Map<String,Object> param){

		return indexService.page(param);
	}
}
