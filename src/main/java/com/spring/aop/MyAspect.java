package com.spring.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Aspect
public class MyAspect {
    private static Logger logger = Logger.getLogger(MyAspect.class);

    //@Before("execution(* com.spring.aop.Order.*(..))")
    public void start() {
        logger.info("开始时间:"+new Date().getTime());
    }
    //@After("execution(* com.spring.aop.Order.*(..))")
    public void end(){
        logger.info("结束时间:"+new Date().getTime());
    }
}
