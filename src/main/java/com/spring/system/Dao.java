package com.spring.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Dao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 开户 注册一个账户
     * @param account
     * @return
     */
    public int register(Account account){
        String sql = "insert into account2 values (?,?,?,?,?,?,to_date(?,'yyyy-mm-dd'),?)";
        return jdbcTemplate.update(sql,account.getAid(),account.getName(),account.getPassword(),account.getSex(),account.getCode(),account.getOpenMoney(),account.getOpenTime(),account.getBalance());
    }

    /**
     * 修改密码
     * @param aid
     * @param newPassword
     * @return
     */
    public int updatePassword(int aid,String newPassword){
        String sql = "update account2 set pass = ? where aid = ?";
        return jdbcTemplate.update(sql,newPassword,aid);
    }

    /**
     * 验证原密码是否正确
     * @param aid
     * @param oldPassword
     * @return
     */
    public int checkPassword(int aid,String oldPassword){
        String sql = "select count(1) from account2 where aid = ? and pass = ?";
        return jdbcTemplate.queryForObject(sql,Integer.class,aid,oldPassword);
    }

    /**
     * 转入
     * @param aid
     * @param money
     * @return
     */
    public int transferIn(int aid,double money){
        String sql = "update account2 set balance = balance + ? where aid = ?";
        return jdbcTemplate.update(sql,money,aid);
    }

    /**
     * 转出
     * @param aid
     * @param money
     * @return
     */
    public int transferOut(int aid,double money){
        String sql = "update account2 set balance = balance - ? where aid = ? and ? <= balance";
        return jdbcTemplate.update(sql,money,aid,money);
    }

    /**
     * 插入交易记录
     * @param transfer
     * @return
     */
    public int addTranfer(Transfer transfer){
        String sql = "insert into transfer2 values(?,?,?,to_date(?,'yyyy-mm-dd'),?)";
        return jdbcTemplate.update(sql,transfer.gettId(),transfer.getaId(),transfer.getTtype(),transfer.getTransTime(),transfer.getTransMoney());
    }

    /**
     * 获取所有账户
     * @return
     */
    public List<Account> getAllAccount(){
        String sql = "select * from account2";
        return jdbcTemplate.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7),rs.getDouble(8));
            }
        });
    }

    /**
     * 获取用户转账总额
     * @param aid
     * @param type
     * @return
     */
    public double getAccountAllTransfer(int aid,String type){
        String sql = "select nvl(sum(trans_money),0.0) from transfer2 where a_id = ? and ttype = ?";
        return jdbcTemplate.queryForObject(sql,double.class,aid,type);
    }

    /**
     * 获取用户开户金额
     * @param aid
     * @return
     */
    public double getAccountOpenMoney(int aid){
        String sql = "select open_money from account2 where aid = ?";
        return jdbcTemplate.queryForObject(sql,Double.class,aid);
    }

    /**
     * 获取用户当前金额
     * @param aid
     * @return
     */
    public double getAccountBalance(int aid){
        String sql = "select balance from account2 where aid = ?";
        return jdbcTemplate.queryForObject(sql,Double.class,aid);
    }

    /**
     * 获取转账记录
     * @param aid
     * @return
     */
    public List<Transfer> getAccountTransfer(int aid){
        String sql = "select * from transfer2 where a_id = ?";
        return jdbcTemplate.query(sql, new RowMapper<Transfer>() {
            @Override
            public Transfer mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Transfer(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
            }
        },aid);
    }
}
