package com.spring.pojo;

public class News {

    private Integer id;
    private String title;
    private String content;
    private String publishTime;
    private Integer readTime;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", readTime=" + readTime +
                '}';
    }

    public News(Integer id, String title, String content, String publishTime, Integer readTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publishTime = publishTime;
        this.readTime = readTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getReadTime() {
        return readTime;
    }

    public void setReadTime(Integer readTime) {
        this.readTime = readTime;
    }
}
