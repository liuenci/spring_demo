package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCore.xml");
        Order order = applicationContext.getBean(Order.class);
        order.doOrder();
        order.updateOrder();
        order.sendProduct();
    }
}
