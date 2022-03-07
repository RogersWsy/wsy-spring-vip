package com.spring;

import com.wsy.AppConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// bean 的创建过程，1，实例化 2，依赖注入 3，初始化
public class WsyApplicationContext {

    private Class configClass;

    private HashMap<String, BeanDefinition> beanMap = new HashMap<String, BeanDefinition>();

    //单例bean
    private HashMap<String, Object> singletonBeanMap = new HashMap<String, Object>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public WsyApplicationContext(Class configClass) {

        this.configClass = configClass;

        //扫描bean
        scan(configClass);
        //创建bean
        for (Map.Entry<String, BeanDefinition> stringBeanDefinitionEntry : beanMap.entrySet()) {
            String beanName = stringBeanDefinitionEntry.getKey();
            BeanDefinition beanDefinition = stringBeanDefinitionEntry.getValue();
            if(beanDefinition.getScope().equals("singleton")){
                Object singletonBean = creatBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName,singletonBean);
            }else{

            }
        }
    }

    private Object creatBean(String beanName, BeanDefinition beanDefinition){
        Class type = beanDefinition.getType();
        Object instance = null;
        try {
            //1.依赖注入
            instance = type.getConstructor().newInstance();
            for (Field field : type.getDeclaredFields()) {
                if(field.isAnnotationPresent(Autowired.class)){//首先看属性上面有没有@Awtowire注解
                    field.setAccessible(true);//开启反射
                    field.set(instance,getBean(field.getName()));
                }
            }
            //2.初始化
            if(instance instanceof InitializingBean){
                ((InitializingBean) instance).afterPropertiesSet();
            }
            //3.
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                beanPostProcessor.postProcessAfterInitialization(instance,beanName);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
      * @Description: 扫描逻辑
      *
     * @param configClass
      * @Author: Wangsy
      * @Date: 3/3/22
      * @Return: void
    **/
    private void scan(Class configClass) {
        if(configClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            //获取到注解的value，也就是扫描包
            String scanPath = componentScan.value();//com.wsy.service
//            System.out.println(scanPath);
            //根据这个路径获取到target中路径下对应的class文件
            scanPath = scanPath.replace(".","/");// 相对路径 com/wsy/service
//            System.out.println(scanPath);
            //获取到类加载器
            ClassLoader classLoader = WsyApplicationContext.class.getClassLoader();
            //获取到 com/wsy/service  相对的路径   也就是全路径
            URL resource = classLoader.getResource(scanPath);
//            System.out.println(resource);
            //根据路径创建文件夹
            File file = new File(resource.getFile());
            //判断file是文件还是文件夹
            if(file.isDirectory()){
                for (File f : file.listFiles()) {
                    //获取到class文件的绝对路径
                    String absolutePath = f.getAbsolutePath();// D:\project2\tuling\wsy-tuling\target\classes\com\wsy\service\UserService.class
//                    System.out.println(absolutePath);
                    //将文件夹路径 \com\wsy\service\UserService.class 改成包引用的格式 com.wsy.service.UserService
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"),absolutePath.indexOf(".class"));
//                    System.out.println(absolutePath);
                    // TODO
//                    absolutePath = absolutePath.replace("\\",".");//windows
                    absolutePath = absolutePath.replace("/",".");//mac

//                    System.out.println(absolutePath);

                    try {
                        //加载class文件
                        Class<?> aClass = classLoader.loadClass(absolutePath);
                        //分析是否有 @component注解  有就是 @bean
                        if(aClass.isAnnotationPresent(Component.class)){

                            //分析是不是实现了BeanPostProcessor接口
                            if(BeanPostProcessor.class.isAssignableFrom(aClass)){
                                BeanPostProcessor instance = (BeanPostProcessor) aClass.getConstructor().newInstance();
                                beanPostProcessorList.add(instance);
                            }

                            //获取到bean的名字
                            Component annotation = aClass.getAnnotation(Component.class);
                            String beanName = annotation.value();
                            if("".equals(beanName)){//没有指定类的名字
                                //根据类名生成一个名字
                                beanName = Introspector.decapitalize(aClass.getSimpleName());//TODO
                            }

                            //设置bean的类型
                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setType(aClass);

                            //判断多例还是单例
                            if(aClass.isAnnotationPresent(Scope.class)){
                                Scope scope = aClass.getAnnotation(Scope.class);
                                String value = scope.value();
                                beanDefinition.setScope(value);
                            }else{
                                beanDefinition.setScope("singleton");
                            }
                            beanMap.put(beanName,beanDefinition);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public Object getBean(String beanName) throws Exception {
        if(!beanMap.containsKey(beanName)){
//            throw new Exception("bean不存在");
            throw new NullPointerException();
        }
        BeanDefinition beanDefinition = beanMap.get(beanName);
        //判断bean是单例还是原型
        String scope = beanDefinition.getScope();
        if("singleton".equals(scope)){
            Object singletonBeanDefinition = singletonBeanMap.get(beanName);
            if(singletonBeanDefinition == null){
                singletonBeanDefinition = creatBean(beanName, beanDefinition);
                singletonBeanMap.put(beanName,singletonBeanDefinition);
            }
            return singletonBeanDefinition;
        }else{
            //多例（原型）
            Object prototypeBean = creatBean(beanName, beanDefinition);
            return prototypeBean;
        }
    }
}
