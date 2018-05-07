package com.spring.jdbc;

import com.spring.dao.EmpDao;
import com.spring.pojo.Emp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextDao.xml");
        EmpDao empDao = applicationContext.getBean(EmpDao.class);
        Emp emp = new Emp(7466,"12","12",7698,"23-1月 -82",300,300,20);
        // empDao.addNewEmp(emp);
        // empDao.updateEmp(emp);
        // empDao.deleteEmp(7466);
        // empDao.queryEmp();
        // empDao.DeptCount();
        empDao.yearCount();
    }
}
