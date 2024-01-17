package com.prodocut.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logging {
    //TODO:çok başlangıç gelişmeli
    Logger logger = LoggerFactory.getLogger(Logging.class);

    @Pointcut(value = "execution(* com.prodocut.*.*.*(..) )")
    public void myPointCut() {
    }


    //@After("execution(* com.prodocut.controller.*.*(..))")
 /*   @Around("myPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("After {} method execution", joinPoint.getSignature().getName());
    }*/

    @Before("myPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        //   System.out.println("Before " + joinPoint.getSignature().getName() + " method execution");
        logger.info("Before " + joinPoint.getSignature().getName() + " method execution");

    }

    @After("myPointCut()")
    public void logAfterd(JoinPoint joinPoint) {
        logger.info("After " + joinPoint.getSignature().getName() + " method execution");
        //  System.out.println("After " + joinPoint.getSignature().getName() + " method execution");
    }


}
