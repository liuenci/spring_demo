package com.spring.service.impl;

import com.spring.pojo.Student;
import com.spring.service.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) throws CloneNotSupportedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();

        Student student = new Student();
        Student student1 = (Student) student.clone();
        System.out.println(student);
        System.out.println(student1);
    }
}
