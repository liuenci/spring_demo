package com.spring.dao;

import com.spring.pojo.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeptTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDao.xml");
        /*DeptDao1 deptDao1 = applicationContext.getBean(DeptDao1.class);
        deptDao1.findAll();*/

        Teacher teacher = applicationContext.getBean(Teacher.class);
        System.out.println(teacher);

        Class<?> teacher1 = Class.forName("Teacher");
        teacher1.getDeclaredMethods();

    }
}
