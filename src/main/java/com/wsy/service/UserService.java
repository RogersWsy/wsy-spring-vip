package com.wsy.service;


import com.spring.*;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Component("userService")
@Scope("prototype")//多例
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

public class UserService implements  UserInterface, BeanNameAware {

    @Autowired
    private OrderService orderService;

    @WsyValue("XXX")
    private String test;

    private String beanName;

    public void test() {
        System.out.println(test);
        System.out.println(orderService);
    }

    @Override
    public void setBeanName(String var1) {
        this.beanName = var1;
    }

//    @Override
//    public void afterPropertiesSet() {
//
//        System.out.println("初始化");
//    }
}
