package com.wsy;

import com.wsy.service.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        context.register();

//        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(context);
//        reader.register(User.class);
//        System.out.println(context.getBean("user"));
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int i = reader.loadBeanDefinitions("spring.xml");

        System.out.println(context.getBean("user"));

    }
}