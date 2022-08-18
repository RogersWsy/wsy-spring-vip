package com.wsy.service;

import com.spring.Component;
import com.wsy.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sound.midi.Soundbank;
import java.util.Locale;

@Component
public class StudentService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test(){
        // sring 启动也会发个事件，所以执行这个方法，监听器会监听到两个
        applicationContext.publishEvent("12345");
        String message = applicationContext.getMessage("test",null,new Locale("zh"));
        System.out.println(message);
    }


}
