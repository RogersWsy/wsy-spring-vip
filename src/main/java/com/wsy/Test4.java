package com.wsy;

import com.wsy.service.StudentService;
import com.wsy.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //下面这段代码的作用也是往spring容器中注入一个bean
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(UserService.class);
        beanDefinition.setScope("prototype");
        context.registerBeanDefinition("userService",beanDefinition);

        UserService userService = (UserService)context.getBean("userService");
        userService.test();

        StudentService studentService = (StudentService) context.getBean("studentService");
        studentService.test();
    }
}
