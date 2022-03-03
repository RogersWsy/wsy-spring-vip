package com.wsy.service;


import com.spring.Autowired;
import com.spring.Component;
import com.spring.InitializingBean;
import com.spring.Scope;

@Component("userService")
@Scope("prototype")
public class UserService implements InitializingBean {

    @Autowired
    private OrderService orderService;

    public void test(){
        System.out.println(orderService);
    }

    @Override
    public void afterPropertiesSet() {

    }
}
