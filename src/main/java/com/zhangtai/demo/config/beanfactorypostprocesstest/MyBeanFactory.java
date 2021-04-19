package com.zhangtai.demo.config.beanfactorypostprocesstest;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanFactory<T> implements FactoryBean<T> {

    private Class<T> type;

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                if (methodName.equals("toString")) {
                    String var35 = this.toString();
                    return var35;
                }

                if (methodName.equals("hashCode")) {
                    Integer var34 = this.hashCode();
                    return var34;
                }

                if (!methodName.equals("equals")) {
                    System.out.println("测试代理");
                    return "111";
                }
                return args[0];
            }
        });
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    @Override
    public Class<T> getObjectType() {
        return this.type;
    }
}
