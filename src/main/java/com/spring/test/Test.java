package com.spring.test;

import com.spring.service.NewsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService newsService = applicationContext.getBean(NewsService.class);
        /*News news = new News(1,"震惊,赞哥原来如此帅","赞哥株洲第一帅", DateUtil.getNowTime(),0);
        newsService.publishNews(news);*/

        newsService.readNews(1);
    }
}
