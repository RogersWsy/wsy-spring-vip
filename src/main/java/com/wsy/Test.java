package com.wsy;

import com.spring.WsyApplicationContext;
import com.wsy.service.UserService;

public class Test {
    public static void main(String[] args) {

//        WsyApplicationContext applicationContext = new WsyApplicationContext(AppConfig.class);

        UserService userService = null;
        int a = 0;
        try {
//            userService = (UserService) applicationContext.getBean("userService");
//            System.out.println(applicationContext.getBean("userService"));
//            System.out.println(applicationContext.getBean("userService"));
//            System.out.println(applicationContext.getBean("orderService"));
//            UserService userService1 = (UserService)applicationContext.getBean("userService");
//            userService1.test();

            a++;
            System.out.println(a);
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(a);
            a++;
            System.out.println(a);
        }
        System.out.println(a);
//        userService.test();
    }
}
