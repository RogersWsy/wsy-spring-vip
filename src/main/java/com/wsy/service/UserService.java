package com.wsy.service;


import com.spring.Autowired;
import com.spring.Component;
import com.spring.InitializingBean;
import com.spring.Scope;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

@Component("userService")
@Scope("prototype")
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

public class UserService implements  UserInterface {

    @Autowired
    private OrderService orderService;

    public void test() {
        System.out.println(orderService);
    }

//    @Override
//    public void afterPropertiesSet() {
//
//        System.out.println("初始化");
//    }
}
