package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {
    @Around("execution(* com.spring.service..*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知");
        proceedingJoinPoint.proceed();
        System.out.println("环绕通知");
    }

    @Before("execution(* com.spring.service..*.*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    @After("execution(* com.spring.service..*.*(..))")
    public void after() {
        System.out.println("后置通知");
    }

}
