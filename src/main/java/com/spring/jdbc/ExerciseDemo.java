package com.spring.jdbc;

import com.google.common.collect.Maps;
import com.spring.pojo.Dept;
import com.spring.pojo.DeptCount;
import com.spring.pojo.Emp;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseDemo extends JdbcDaoSupport{
    /**
     * 统计每个部门的人数，并按人数从多到少排序
     */
    public void DeptCount(){
        String sql = "select deptno,count(1) num from emp group by deptno order by num desc";
        List<DeptCount> deptCountList = getJdbcTemplate().query(sql, new RowMapper<DeptCount>() {

            @Override
            public DeptCount mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new DeptCount(rs.getInt(1),rs.getInt(2));
            }
        });
        for (DeptCount deptCount : deptCountList){
            System.out.println(deptCount);
        }
    }

    /**
     * 统计每个月入职的人数
     */
    public void monthCount(){
        String sql = "select to_char(hiredate,'mm'),count(1) from emp group by to_char(hiredate,'mm')";
        List<Map<String,Object>> mapList = getJdbcTemplate().query(sql, new RowMapper<Map<String,Object>>() {
            @Override
            public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map map = Maps.newHashMap();
                map.put(rs.getString(1),rs.getInt(2));
                return map;
            }
        });
        for (Map map : mapList){
            System.out.println(map);
        }
    }

    /**
     * 查询月薪高于平均月薪（sal）的员工信息
     */
    public void salDept(){
        String sql = "select * from emp where sal > (select avg(sal) from emp)";
        List<Emp> empList = getJdbcTemplate().query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(7));
            }
        });
        for (Emp emp : empList){
            System.out.println(emp.getEmpno()+" "+emp.getEname());
        }
    }

    /**
     * 查询部门人数小于3个的部门信息
     */
    public void numDept(){
        String sql = "select * from dept where deptno in (select deptno from emp  group by deptno having count(1) < 3)";
        List<Dept> deptList = getJdbcTemplate().query(sql, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        });
        for (Dept dept : deptList){
            System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
        }
    }

    /**
     * 打印出所有部门经理的信息
     */
    public void bossInfo(){
        String sql = "select * from emp where mgr is null";
        List<Emp> empList = getJdbcTemplate().query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
            }
        });
        for (Emp emp : empList){
            System.out.println(emp.getEmpno()+" "+emp.getEname());
        }
    }

    /**
     * 打印出7499号员工的领导信息
     */
    public void printBossInfo(){
        String sql = "select * from emp where empno =  ( select mgr from emp where empno = 7499)";
        List<Emp> empList = getJdbcTemplate().query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
            }
        });
        for (Emp emp : empList){
            System.out.println(emp.getEmpno()+" "+emp.getEname());
        }
    }

    /**
     * 添加一个新部门，并为该部门添加两个员工
     */
    public void insert(){
        String sql = "insert into dept values(11,'11','11')";
        getJdbcTemplate().update(sql);
        sql = "insert into emp values(7498,'11','11',7698,'23-1月 -82',300,300,20)";
        getJdbcTemplate().update(sql);
        sql = "insert into emp values(7411,'11','11',7698,'23-1月 -82',300,300,20)";
        getJdbcTemplate().update(sql);
    }

    /**
     * 计算公司每个月需要发放的总的工资
     */
    public void allSal(){
        String sql = "select sum(sal+ nvl2(comm,comm,0)) from emp";
        Integer integer = getJdbcTemplate().queryForObject(sql,Integer.class);
        System.out.println(integer);
    }
}
