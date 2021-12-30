package com.wsy;

import com.spring.WsyApplicationContext;
import com.wsy.service.UserService;

public class Test {
    public static void main(String[] args) {

        WsyApplicationContext applicationContext = new WsyApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
    }
}
