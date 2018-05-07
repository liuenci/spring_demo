package com.spring.pojo;

import java.util.Date;

public class Teacher {
    private String name;
    private String sex;
    private String techonogy;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTechonogy() {
        return techonogy;
    }

    public void setTechonogy(String techonogy) {
        this.techonogy = techonogy;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
