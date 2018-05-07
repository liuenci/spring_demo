package com.spring.dao;

import com.spring.pojo.Dept;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DeptDao1 {

    // 直接在 dao 中注入 JdbcTemplate 对象
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Value("${app.prop}")
    private String prop;


    /**
     * 查询所有部门
     * @return
     */
    public List<Dept> findAll(){
        System.out.println(prop);

        String sql = "select * from dept";
        return jdbcTemplate.query(sql, new RowMapper<Dept>() {
            @Override
            public Dept mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
        });
    }

    /**
     * 修改部门名称
     */
    public int update(int id,String deptName){
        String sql = "update dept set dname = ? where deptno = ?";
        return jdbcTemplate.update(sql,deptName,id);
    }
}
