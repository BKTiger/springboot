package com.zhangtai.demo.controller;

import com.zhangtai.demo.Service.MongodbService;
import com.zhangtai.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {

	@Autowired
	private MongodbService mongodbService;

	@RequestMapping("/findAll")
	public List<Student> findAll(){
		List<Student> all = mongodbService.findAll();
		return all;
	}
}
