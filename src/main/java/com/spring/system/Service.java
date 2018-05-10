package com.spring.system;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service("iService")
public class Service {
    private static Logger logger = Logger.getLogger(Service.class);

    @Autowired
    private Dao dao;

    /**
     * 开户
     * @param account
     */
    public void register(Account account){
        int result = dao.register(account);
        if (result > 0){
            logger.debug("注册账户成功");
            return;
        }
        logger.debug("注册账户失败");
    }

    /**
     * 修改密码
     * @param aid
     * @param oldPassword
     * @param newPassword
     */
    public void updatePassword(int aid,String oldPassword,String newPassword){
        int checkResult = dao.checkPassword(aid,oldPassword);
        if (checkResult == 0){
            logger.info("用户不存在或者密码错误");
            return;
        }
        int updateResult = dao.updatePassword(aid,newPassword);
        if (updateResult == 0){
            logger.info("更新密码失败");
            return;
        }
        logger.info("更新密码成功");
    }

    /**
     * 转账
     * @param transfer1
     * @param transfer2
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void transfer(Transfer transfer1,Transfer transfer2) throws Exception {
        int transferInResult = dao.transferIn(transfer1.getaId(),transfer1.getTransMoney());
        int transferOutResult = dao.transferOut(transfer2.getaId(),transfer2.getTransMoney());
        if (transferInResult == 0 || transferOutResult == 0 ){
            logger.info("转账失败");
            throw new Exception();
        }
        int transferResult1 = dao.addTranfer(transfer1);
        int transferResult2 = dao.addTranfer(transfer2);
        if (transferResult1 == 0 || transferResult2 == 0){
            logger.info("日志打印失败");
            throw new Exception();
        }
        logger.info("转账成功，日志输入成功");
    }

    /**
     * 对账
     */
    public void checkMoney(){
        List<Account> accountList = dao.getAllAccount();
        if (accountList.isEmpty()){
            logger.info("系统还没有任何账户");
            return;
        }
        for (Account account : accountList){
            // 获取账户开户金额
            double openMoney = dao.getAccountOpenMoney(account.getAid());
            // 获取转出总金额
            double transferOut = dao.getAccountAllTransfer(account.getAid(),"转出");
            // 获取转入总金额
            double transferIn = dao.getAccountAllTransfer(account.getAid(),"转入");
            // 获取账户余额
            double balance = dao.getAccountBalance(account.getAid());
            boolean result = balance == openMoney - transferOut + transferIn;
            if (result == true){
                logger.info(account.getName()+":对账成功无坏账");
            }else{
                logger.info(account.getName()+":对账成功发现坏账");
            }
        }
    }

    /**
     * 获取所有交易记录
     * @param aid
     */
    public void getAccountTransfer(int aid){
        List<Transfer> transferList = dao.getAccountTransfer(aid);
        if (transferList.isEmpty()){
            logger.info("没有交易记录");
            return;
        }
        for (Transfer transfer : transferList){
            logger.info(transfer);
        }
    }
}
