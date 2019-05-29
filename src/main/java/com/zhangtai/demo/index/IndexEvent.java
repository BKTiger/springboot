package com.zhangtai.demo.index;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhangtai
 * @date 2019/5/7 15:37
 * @Description:事件对象
 */

public class IndexEvent extends ApplicationEvent {
    public IndexEvent(Object source) {
        super(source);
    }
}
