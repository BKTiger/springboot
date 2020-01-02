package com.zhangtai.demo.index;

import com.zhangtai.demo.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@Autowired
	RabbitTemplate rabbitTemplate;
	@RequestMapping("/")
	public String showIndex(Model model){

		String message = "send email message to user";
		/**
		 String message = "send email message to user";
		 /**
		 * 参数
		 * 1. 交换机名称
		 * 2. routingkey名称
		 * 3. 消息
		 */
		rabbitTemplate.convertAndSend(RabbitmqConfig.QUEUE_INFORM_EMALL,message);


		model.addAttribute("slogan", "智慧建筑方案提供商");
		return "index";
	}

}
