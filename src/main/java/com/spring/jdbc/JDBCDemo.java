package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDao.xml");
        ExerciseDemo exerciseDemo = applicationContext.getBean("exerciseDemo",ExerciseDemo.class);
        exerciseDemo.DeptCount();
        exerciseDemo.monthCount();
        exerciseDemo.salDept();
        exerciseDemo.numDept();
        exerciseDemo.bossInfo();
        exerciseDemo.printBossInfo();
        //exerciseDemo.insert();
        exerciseDemo.allSal();
    }

}
