package com.spring.core;

import com.spring.pojo.DI;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class SpringCoreTest {
    private static Logger logger = Logger.getLogger(SpringCoreTest.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCore.xml");

        DI di = applicationContext.getBean("di",DI.class);
        Map<Object,Object> map = di.getMap();
        for (Map.Entry<Object,Object> entry : map.entrySet()){
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }

        Set set = di.getSet();
        for (Object key : set){
            System.out.println(key);
        }
        List list = di.getList();
        for (Object object : list){
            System.out.println(object);
        }

        Properties properties = di.getPro();
        Set<Object> keys = properties.keySet();
        for (Object key : keys){
            System.out.println("key:"+key.toString()+" value:"+properties.get(key));
        }
    }
}
