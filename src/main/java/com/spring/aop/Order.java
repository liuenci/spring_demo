package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Order {
    public void doOrder(){
        System.out.println("下订单");
    }

    public void updateOrder(){
        System.out.println("修改订单状态");
    }

    public void sendProduct(){
        System.out.println("发货");
    }


}
