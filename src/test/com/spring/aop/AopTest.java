package com.spring.aop;

import com.spring.service.Service1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCore.xml");
        Service1 service1 = applicationContext.getBean(Service1.class);
        System.out.println(service1.getClass().getName());
        service1.sayHello();
    }
}
