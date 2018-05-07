package com.spring.dao;

import com.spring.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class NewsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 发布新文章
     * @param news
     * @return
     */
    public Integer publishNews(News news){
        String sql = "INSERT INTO NEWS (ID, TITLE, CONTENT, PUBLISH_TIME, READ_NUM) VALUES (?, ?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), ?)";
        return jdbcTemplate.update(sql,news.getId(),news.getTitle(),news.getContent(),news.getPublishTime(),news.getReadTime());
    }

    /**
     * 更新新闻浏览次数
     * @param newsId
     * @return
     */
    public Integer updateReadTime(int newsId){
        String sql = "update news set read_num = read_num + 1 where id = ?";
        return jdbcTemplate.update(sql,newsId);
    }

    /**
     * 查看新闻
     * @param newsId
     * @return
     */
    public News getNewsById(int newsId){
        String sql = "select * from news where id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
            }
        },newsId);
    }

}
