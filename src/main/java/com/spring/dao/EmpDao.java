package com.spring.dao;

import com.google.common.collect.Maps;
import com.spring.pojo.DeptCount;
import com.spring.pojo.Emp;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class EmpDao extends JdbcDaoSupport{
    /**
     * 添加新员工
     */
    public void addNewEmp(Emp emp){
        String sql = "insert into emp values (?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql,emp.getEmpno(),emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno());
    }

    /**
     * 更新员工
     * @param emp
     */
    public void updateEmp(Emp emp){
        String sql = "update emp set ename = ?,job = ?,mgr = ?,hiredate = ?,sal = ?,comm = ?,deptno = ? where empno = ?";
        getJdbcTemplate().update(sql,emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),emp.getSal(),emp.getComm(),emp.getDeptno(),emp.getEmpno());
    }

    /**
     * 删除员工
     * @param empno
     */
    public void deleteEmp(int empno){
        String sql = "delete from emp where empno = ?";
        getJdbcTemplate().update(sql,empno);
    }

    /**
     * 查询所有员工
     */
    public void queryEmp(){
        String sql = "select * from emp";
        List<Emp> empList =  getJdbcTemplate().query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
            }
        });
        for (Emp emp : empList){
            System.out.println(emp.getEmpno()+","+emp.getEname());
        }
    }
    /**
     * 统计每个部门的人数
     */
    public void DeptCount(){
        String sql = "select deptno,count(1) num from emp group by deptno";
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
     * 统计每年入职的人数
     */
    public void yearCount(){
        String sql = "select to_char(hiredate,'yyyy'),count(1) from emp group by to_char(hiredate,'yyyy')";
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
}
