package com.wsy;

import com.wsy.service.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class Test5 {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
//        context.register();

//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
//        reader.register(User.class);
//        System.out.println(context.getBean("user"));

//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
//        int i = reader.loadBeanDefinitions("spring.xml");
//        System.out.println(context.getBean("user"));
//
//        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
//        scanner.scan("com.wsy");
//        System.out.println(context.getBean("user"));

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(User.class);

        beanFactory.registerBeanDefinition("user",beanDefinition);
        System.out.println(beanFactory.getBean("user"));
    }
}