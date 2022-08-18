package com.wsy;

import com.wsy.service.User;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.refresh();
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

//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(User.class);
//
//        beanFactory.registerBeanDefinition("user",beanDefinition);
//        System.out.println(beanFactory.getBean("user"));
        System.out.println(context.getMessage("test", null, new Locale("en")));

//        Resource resource = context.getResource("file://Users/wangsiyue/TuLing/wsy-spring-vip/src/main/java/com/wsy/AppConfig.java");
//        System.out.println(resource.contentLength());
        Resource resource1 = context.getResource("classpath:spring.xml");
        System.out.println(resource1.contentLength());
        Resource resource2 = context.getResource("https://www.baidu.com");
        System.out.println(resource2.contentLength());

        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println("systemEnvironment:"+systemEnvironment);

        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
        System.out.println("systemProperties:"+systemProperties);

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        System.out.println("propertySources:"+propertySources);

        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
        System.out.println(context.getEnvironment().getProperty("wsy"));
    }
}