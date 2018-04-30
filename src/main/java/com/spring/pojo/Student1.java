package com.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class Student1 {

    public void study(){
        System.out.println("学习");
    }

    public void rest(){
        System.out.println("休息");
    }
}
