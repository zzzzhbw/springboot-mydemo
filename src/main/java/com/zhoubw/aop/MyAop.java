package com.zhoubw.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Slf4j
public class MyAop {

    @Pointcut("execution(* com.zhoubw.controller..*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void dobefore(JoinPoint jp){
        log.info("before可以做的");
    }

    @After("pointCut()")
    public void doafter(JoinPoint jp){
        log.info("after可以做的");
    }
}
