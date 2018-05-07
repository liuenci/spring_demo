package com.spring.service;


import com.spring.dao.NewsDao;
import com.spring.pojo.News;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class NewsService {
    private static Logger logger = Logger.getLogger(NewsService.class);
    @Autowired
    private NewsDao newsDao;

    /**
     * 发布新闻
     * @param news
     */
    public void publishNews(News news){
        int result = newsDao.publishNews(news);
        if (result > 0){
            logger.info("发布新闻成功");
            return;
        }
        logger.error("发布新闻失败");
    }

    /**
     * 阅读新闻
     * @param newsId
     */
    public News readNews(int newsId){
        News news = newsDao.getNewsById(newsId);
        if (news == null){
            logger.info("没有该新闻");
        }
        int result = newsDao.updateReadTime(newsId);
        if (result > 0){
            logger.info(news);
            return news;
        }
        logger.info("阅读新闻失败");
        return null;
    }
}
