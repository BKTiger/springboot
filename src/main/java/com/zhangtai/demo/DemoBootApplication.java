package com.zhangtai.demo;

import com.leimingtech.framework.elk.log.monitor.MonitorLogger;
import com.leimingtech.framework.elk.log.monitor.MonitorLoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.leimingtech.*","com.zhangtai.demo.*"})
public class DemoBootApplication {

	// 声明监控日志常量
	private static final MonitorLogger MONITOR_LOGGER = MonitorLoggerFactory.getMonitorLogger(DemoBootApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(DemoBootApplication.class, args);
		// 输出监控日志
		MONITOR_LOGGER.info("200100", "监控日志应用启动成功！");
	}
}
