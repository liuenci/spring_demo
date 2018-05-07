package com.spring.service;

import com.spring.dao.DeptDao1;
import com.spring.pojo.Dept;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// @Transactional 注明在类上，表示作用在此类下面的所有方法
public class DeptService {
    private static Logger logger = Logger.getLogger(DeptService.class);
    @Autowired
    private DeptDao1 deptDao1;

    @Transactional(rollbackFor = Exception.class)
    public void changeDept() {
        deptDao1.update(80, "湖南工业大学1");
        // int i = 1 / 0;
        deptDao1.update(80, "湖南工业大学2");
    }

    public List<Dept> findAll(){
        return deptDao1.findAll();
    }
}
