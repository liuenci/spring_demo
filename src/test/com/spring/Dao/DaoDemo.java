package com.spring.Dao;

import com.spring.dao.DeptDao;
import com.spring.pojo.Dept;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDao.xml");
        DeptDao deptDao = applicationContext.getBean(DeptDao.class);
        // deptDao.insert(new Dept(11,"火星","北京"));
        // deptDao.update(new Dept(11,"水星","上海"));
        // deptDao.delete(11);
        // Dept dept = deptDao.load(80);
        List<Dept> deptList = deptDao.queryAll();
        System.out.println(deptList.get(0).getDname());
    }
}
