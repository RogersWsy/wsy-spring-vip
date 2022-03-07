package com.wsy;

import com.spring.WsyApplicationContext;
import com.wsy.service.UserInterface;
import com.wsy.service.UserService;

public class Test {
    public static void main(String[] args) {

        //扫描 ---> 创建单例Bean
        WsyApplicationContext applicationContext = new WsyApplicationContext(AppConfig.class);

//        UserService userService = null;
        int a = 0;
        try {
//            userService = (UserService) applicationContext.getBean("userService");
//            System.out.println(applicationContext.getBean("userService"));
//            System.out.println(applicationContext.getBean("userService"));
//            System.out.println(applicationContext.getBean("orderService"));
//            UserInterface userInterface = (UserInterface)applicationContext.getBean("userService");//JDK自带的，不能强转成实现类，因为这里代理的是接口，所以要强转成userInterface
//            userInterface.test();
//            userService1.test();

//            a++;
//            System.out.println(a);
//            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(a);
            a++;
//            System.out.println(a);
        }
//        System.out.println(a);
//        userService.test();
    }
}
