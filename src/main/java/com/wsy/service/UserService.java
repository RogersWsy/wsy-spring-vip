package com.wsy.service;


import com.spring.Component;
import com.spring.Scope;

@Component("userService")
@Scope("prototype")
public class UserService {

    public void test(){
        System.out.println("有@component注解");
    }
}
