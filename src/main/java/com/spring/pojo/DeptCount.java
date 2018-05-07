package com.spring.pojo;

public class DeptCount {

    private int deptno;
    private int count;

    public DeptCount(int deptno, int count) {
        this.deptno = deptno;
        this.count = count;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "DeptCount{" +
                "deptno=" + deptno +
                ", count=" + count +
                '}';
    }
}
