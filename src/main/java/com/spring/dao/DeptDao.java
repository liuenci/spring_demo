package com.spring.dao;

import com.spring.pojo.Dept;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DeptDao extends JdbcDaoSupport{

    public void insert(Dept dept){
        String sql = "insert into dept values(?,?,?)";
        getJdbcTemplate().update(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
    }

    public void update(Dept dept){
        String sql = "update dept set dname = ?,loc = ? where deptno = ?";
        getJdbcTemplate().update(sql,dept.getDname(),dept.getLoc(),dept.getDeptno());
    }

    public void delete(int deptno){
        String sql = "delete from dept where deptno = ?";
        getJdbcTemplate().update(sql,deptno);
    }

    public Dept load(int deptno){
        String sql = "select * from dept where deptno = ?";
        return getJdbcTemplate().queryForObject(sql, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        },deptno);
    }

    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> queryAll(){
        String sql = "select * from dept";
        return getJdbcTemplate().query(sql, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        });
    }

    public void update(long id,String deptName){
        String sql = "update dept";
    }
}
