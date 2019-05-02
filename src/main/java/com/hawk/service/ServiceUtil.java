package com.hawk.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.hawk.annotation.MyAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zhangdonghao
 * @date 2019/4/20
 * 自定义注解被spring扫描
 */
@Service
public class ServiceUtil implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        ClassPathBeanDefinitionScanner cpbs = new ClassPathBeanDefinitionScanner(beanDefinitionRegistry);
        cpbs.addIncludeFilter(new AnnotationTypeFilter(MyAnnotation.class));
        System.out.println("自定义注解扫描配置 =================================");
        cpbs.scan("com.hawk.dao");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
