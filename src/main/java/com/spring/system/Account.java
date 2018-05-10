package com.spring.system;

public class Account {

    private Integer aid;
    private String name;
    private String password;
    private String sex;
    private String code;
    private double openMoney;
    private String openTime;
    private double balance;

    @Override
    public String toString() {
        return "account{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", code='" + code + '\'' +
                ", openMoney=" + openMoney +
                ", openTime='" + openTime + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account() {
    }

    public Account(Integer aid, String name, String password, String sex, String code, double openMoney, String openTime, double balance) {
        this.aid = aid;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.code = code;
        this.openMoney = openMoney;
        this.openTime = openTime;
        this.balance = balance;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getOpenMoney() {
        return openMoney;
    }

    public void setOpenMoney(double openMoney) {
        this.openMoney = openMoney;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
