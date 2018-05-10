package com.spring.system;

public class Transfer {

    private Integer tId;
    private Integer aId;
    private String ttype;
    private String transTime;
    private double transMoney;

    public Transfer() {
    }

    public Transfer(Integer tId, Integer aId, String ttype, String transTime, double transMoney) {
        this.tId = tId;
        this.aId = aId;
        this.ttype = ttype;
        this.transTime = transTime;
        this.transMoney = transMoney;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public double getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(double transMoney) {
        this.transMoney = transMoney;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "tId=" + tId +
                ", aId=" + aId +
                ", ttype='" + ttype + '\'' +
                ", transTime='" + transTime + '\'' +
                ", transMoney=" + transMoney +
                '}';
    }
}
