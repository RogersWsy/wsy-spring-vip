package com.wsy.service;

import com.wsy.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.sound.midi.Soundbank;
import java.util.Locale;

public class UserService1 implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void test(){
        String message = applicationContext.getMessage("test",null,new Locale("zh"));
        System.out.println(message);
    }


}
