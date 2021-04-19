package com.zhangtai.demo.config.beanfactorypostprocesstest;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

public class MyClassScanner extends ClassPathBeanDefinitionScanner {
    public MyClassScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        AnnotationMetadata metadata = beanDefinition.getMetadata();
        return true;
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages){
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) beanDefinitionHolder.getBeanDefinition();
            String beanName = beanDefinitionHolder.getBeanName();
            String beanClassName = beanDefinition.getBeanClassName();
            if(beanName.equals("myTestInterface")){
                beanDefinition.setBeanClass(MyBeanFactory.class);
                beanDefinition.getPropertyValues().add("type",beanClassName);
            }
        }
        return beanDefinitionHolders;
    }
}
