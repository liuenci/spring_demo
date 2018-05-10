package com.spring.system;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
    public static ApplicationContext applicationContext;

    @BeforeClass
    public static void init(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    }
    @Test
    public void testRegister(){
        Account account = new Account();
        account.setAid(3);
        account.setName("liuenci");
        account.setPassword("123456");
        account.setSex("男");
        account.setCode("431");
        account.setOpenMoney(1000);
        account.setOpenTime("2018-5-7");
        account.setBalance(1000);
        Service service = applicationContext.getBean("iService",Service.class);
        service.register(account);
    }

    @Test
    public void testCheckPassword(){
        Service service = applicationContext.getBean("iService",Service.class);
        service.updatePassword(1,"123456","222222");
    }
    @Test
    public void testTransfer() throws Exception {
        Transfer transfer1 = new Transfer();
        transfer1.settId(5);
        transfer1.setaId(3);
        transfer1.setTransMoney(100);
        transfer1.setTransTime("2018-5-7");
        transfer1.setTtype("转出");

        Transfer transfer2 = new Transfer();
        transfer2.settId(6);
        transfer2.setaId(2);
        transfer2.setTransMoney(100);
        transfer2.setTransTime("2018-5-7");
        transfer2.setTtype("转入");

        Service service = applicationContext.getBean("iService",Service.class);
        service.transfer(transfer2,transfer1);
    }

    @Test
    public void testCheckMoney(){
        Service service = applicationContext.getBean("iService",Service.class);
        service.checkMoney();
    }
    @Test
    public void testAccountTransfer(){
        Service service = applicationContext.getBean("iService",Service.class);
        service.getAccountTransfer(1);
    }
}
