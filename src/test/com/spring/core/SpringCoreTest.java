package com.spring.core;

import com.spring.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringCoreTest {
    private static Logger logger = Logger.getLogger(SpringCoreTest.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCore.xml");
        // 创建对象的两种方式
        Student student = (Student) applicationContext.getBean("student");
        student.setId(1);
        student.setName("tom");
        logger.info(student.getId() + " " + student.getName());

        Student student1 = applicationContext.getBean("student",Student.class);
        student1.setId(2);
        student1.setName("Marry");
        logger.info(student1.getId() + " " + student1.getName());
    }
}
