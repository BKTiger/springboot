package com.zhangtai.demo.index;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author zhangtai
 * @date 2019/5/7 15:45
 * @Description:
 */
@Component
public class SmsListener implements ApplicationListener<IndexEvent> {
    @Override
    public void onApplicationEvent(IndexEvent indexEvent) {
        System.out.println("可以这样吗");
    }

}
