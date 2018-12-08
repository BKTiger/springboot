package com.zhangtai.demo;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoBootApplicationTests {

	/* *
	 * 功能描述: html静态化测试类
	 *
	 * @param: []
	 * @return: void
	 * @auther: zhangtai
	 * @date: 2018/12/8 15:06
	 */
	@Test
	public void testGenerateHtml() throws IOException, TemplateException {
		//定义配置类
		Configuration configuration  = new Configuration(Configuration.getVersion());
		//得到classPath的路径
		String path = this.getClass().getResource("/").getPath();
		//定义模板路径
		configuration.setDirectoryForTemplateLoading(new File(path+"/templates/"));
		//获取模板文件的内容
		Template template = configuration.getTemplate("templatesTest.ftl");
		//定义数据模型
		Map<String,Object> map = new HashMap<>();
		map.put("name","张岱");
		map.put("age",25);
		//静态化
		String context = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		//输出到文件 导入阿帕奇 common-io的工具包
		InputStream inputStream = IOUtils.toInputStream(context);
		FileOutputStream outputStream = new FileOutputStream(new File(  "D:/templates/" + "testHtml.html"));
		IOUtils.copy(inputStream,outputStream);
		inputStream.close();
		outputStream.close();
	}

	@Test
	public void testGenerateString() throws IOException, TemplateException {
		//定义配置类
		Configuration configuration  = new Configuration(Configuration.getVersion());
		//定义模板
		//模板内容(字符串)
		String templateString = "<!DOCTYPE html>\n" +
				"<html>\n" +
				"<head>\n" +
				"    <meta charset=\"utf-8\" />\n" +
				"    <title>智慧工程</title>\n" +
				"</head>\n" +
				"<body>\n" +
				"Name:${name}<br/>\n" +
				"Age:${age}\n" +
				"</body>\n" +
				"</html>";
		//使用一个模板加载器变为模板
		StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
		stringTemplateLoader.putTemplate("stringTemplate",templateString);
		//在配置中设置模板加载器
		configuration.setTemplateLoader(stringTemplateLoader);
		Template template = configuration.getTemplate("stringTemplate", "utf-8");
		//定义数据模型
		Map<String,Object> map = new HashMap<>();
		map.put("name","张岱");
		map.put("age",25);
		//静态化
		String context = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		//输出到文件 导入阿帕奇 common-io的工具包
		InputStream inputStream = IOUtils.toInputStream(context);
		FileOutputStream outputStream = new FileOutputStream(new File(  "D:/templates/" + "testHtml.html"));
		IOUtils.copy(inputStream,outputStream);
		inputStream.close();
		outputStream.close();
	}
}
