package com.zhangtai.demo.index;

import com.zhangtai.demo.common.exception.ExceptionCast;
import com.zhangtai.demo.common.result.impl.CommonResultCode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	/* *
	 * 功能描述: 测试自定义异常
	 *
	 * @param: [model]
	 * @return: java.lang.String
	 * @auther: zhangtai
	 * @date: 2018/12/5 23:12
	 */
	@RequestMapping("/commonException")
	public String commonException(Model model){
		//测试
		if(1==1){
			ExceptionCast.cast(CommonResultCode.FAIL);
		}
		return "index";
	}
	/* *
	 * 功能描述: 测试非自定义异常
	 *
	 * @param: [model]
	 * @return: java.lang.String
	 * @auther: zhangtai
	 * @date: 2018/12/5 23:12
	 */
	@RequestMapping("/zero")
	public String zeroException(Model model){
		int i = 1/0;

		return "index";
	}

}
