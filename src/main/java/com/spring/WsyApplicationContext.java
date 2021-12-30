package com.spring;

import com.wsy.AppConfig;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;

public class WsyApplicationContext {

    private Class configClass;

    public WsyApplicationContext(Class configClass) {

        this.configClass = configClass;

        if(configClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan componentScan = (ComponentScan)configClass.getAnnotation(ComponentScan.class);
            //获取到注解的value，也就是扫描包
            String scanPath = componentScan.value();//com.wsy.service
            System.out.println(scanPath);
            //根据这个路径获取到target中路径下对应的class文件
            scanPath = scanPath.replace(".","/");// 相对路径 com/wsy/service
            System.out.println(scanPath);
            //获取到类加载器
            ClassLoader classLoader = WsyApplicationContext.class.getClassLoader();
            //获取到 com/wsy/service  相对的路径   也就是全路径
            URL resource = classLoader.getResource(scanPath);
            System.out.println(resource);
            //根据路径创建文件夹
            File file = new File(resource.getFile());
            //判断file是文件还是文件夹
            if(file.isDirectory()){
                for (File f : file.listFiles()) {
                    //获取到class文件的绝对路径
                    String absolutePath = f.getAbsolutePath();// D:\project2\tuling\wsy-tuling\target\classes\com\wsy\service\UserService.class
                    System.out.println(absolutePath);
                    //将文件夹路径 \com\wsy\service\UserService.class 改成包引用的格式 com.wsy.service.UserService
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"),absolutePath.indexOf(".class"));
                    System.out.println(absolutePath);
                    absolutePath = absolutePath.replace("\\",".");
                    System.out.println(absolutePath);

                    try {
                        //加载class文件
                        Class<?> aClass = classLoader.loadClass(absolutePath);
                        //分析是否有 @component注解  有就是 @bean
                        if(aClass.isAnnotationPresent(Component.class)){
                            //判断多例还是单例
                            if(aClass.isAnnotationPresent(Scope.class)){
                                Scope scope = aClass.getAnnotation(Scope.class);

                                if("singleton".equals(scope.value())){

                                }else{

                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public Object getBean(String beanName){
        return null;
    }
}
