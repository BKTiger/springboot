package com.zhangtai.demo.littleDog;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author zhangtai
 * @date 2019/5/7 14:50
 * @Description:
 */
@Service
public class AfterSpring implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        String applicationName = applicationContext.getApplicationName();
        Environment environment = applicationContext.getEnvironment();
        final Object indexController = applicationContext.getBean("indexController");
        System.out.println("启动spring后执行");
    }
}
