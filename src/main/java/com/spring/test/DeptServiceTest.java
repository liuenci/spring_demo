package com.spring.test;

import com.spring.dao.DeptDao1;
import com.spring.pojo.Dept;
import com.spring.service.DeptService;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


public class DeptServiceTest {

    public static ApplicationContext applicationContext;

    private static Logger logger = Logger.getLogger(DeptServiceTest.class);
    @BeforeClass
    public static void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test1(){
        // 获取 dao 对象
        DeptDao1 deptDao1 = applicationContext.getBean(DeptDao1.class);
        List<Dept> deptList = deptDao1.findAll();
        for (Dept dept : deptList){
            System.out.println(dept);
        }
    }

    /**
     * 事务测试
     */
    @Test
    public void test2(){
        DeptService deptService = applicationContext.getBean(DeptService.class);
        deptService.changeDept();
    }

    /**
     * 只读事务，只能做查询操作，不能做更新操作
     */
    @Test
    public void test3(){
        DeptService deptService = applicationContext.getBean(DeptService.class);
        List<Dept> deptList = deptService.findAll();
        for (Dept dept : deptList){
            System.out.println(dept);
        }
    }

}
