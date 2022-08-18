package com.wsy.service;


import com.spring.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Locale;

//@Component("userService")
//@Scope("prototype")//多例
//@Scope("singleton")//单例
//public class UserService implements  InitializingBean {
//
//    @Autowired
//    private OrderService orderService;
//
//    public void test(){
//        System.out.println(orderService);
//    }
//
//    @Override
//    public void afterPropertiesSet() {
//
//        System.out.println("初始化");
//    }
//}
@Component
public class UserService /*implements  UserInterface, BeanNameAware*/implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Autowired
    private OrderService orderService;

    @WsyValue("XXX")
    private String test;

    private String beanName;

    public void test() {
        // sring 启动也会发个事件，所以执行这个方法，监听器会监听到两个
        applicationContext.publishEvent("12345");
        String message = applicationContext.getMessage("test",null,new Locale("zh"));
        System.out.println(message);

        System.out.println(test);
        System.out.println(orderService);
        System.out.println(beanName);
    }

//    @Override
//    public void setBeanName(String var1) {
//        this.beanName = var1;
//    }

//    @Override
//    public void afterPropertiesSet() {
//
//        System.out.println("初始化");
//    }
}
