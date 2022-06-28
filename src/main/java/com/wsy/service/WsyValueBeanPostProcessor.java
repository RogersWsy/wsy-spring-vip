package com.wsy.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

import java.lang.reflect.Field;

@Component
//Bean的后置处理器    spring的切面编程AOP就是基于这种机制
public class WsyValueBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        for (Field field : bean.getClass().getFields()) {
            if (field.isAnnotationPresent(WsyValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean,field.getAnnotation(WsyValue.class).value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return bean;
    }
}
