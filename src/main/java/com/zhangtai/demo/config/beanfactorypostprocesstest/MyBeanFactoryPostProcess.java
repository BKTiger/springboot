package com.zhangtai.demo.config.beanfactorypostprocesstest;

import com.bktiger.annotation.TestAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor{
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // 使用spring自带的方法添加扫描范围外的目录
        /*
        BeanDefinitionRegistry registry  = (BeanDefinitionRegistry) configurableListableBeanFactory;
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(registry);
        scanner.scan(new String[]{"com.bktiger"});
        */
        // 自定义scanner扫描有指定标识的类
        BeanDefinitionRegistry registry  = (BeanDefinitionRegistry) configurableListableBeanFactory;
        // 在自定义的Scanner中重写了isCandidateComponent方法，可以配置扫描的文件
        MyClassScanner scanner = new MyClassScanner(registry);
        // scanner.resetFilters(false); // 设置后无法扫描到@service 标注的TestBean类
        scanner.addIncludeFilter(new AnnotationTypeFilter(TestAnnotation.class));// 设置后可扫描到MyAnnotationBean
        // 重写doScan方法可以结合FactoryBean对接口类型实现代理实现，或者对某已实现的类进行修改
        scanner.scan(new String[]{"com.bktiger"});
    }
}
