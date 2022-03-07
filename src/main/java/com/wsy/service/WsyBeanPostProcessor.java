package com.wsy.service;

import com.spring.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//Bean的后置处理器    spring的切面编程AOP就是基于这种机制
public class WsyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

//        if(beanName.equals("userService")){
//            //创建一个动态代理对象；jdk 的动态代理基于接口实现的，
//            //三个参数 类加载器，被代理的接口，InvocationHandler
//            Object proxyInstance = Proxy.newProxyInstance(WsyBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
//                @Override
//                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                    // 切面
//                    System.out.println("切面逻辑");
//
//                    return method.invoke(bean,args);//执行原始bean的方法，而不是代理对象的。
//                }
//            });
//
//        }
        System.out.println(beanName);
        return bean;
    }
}
