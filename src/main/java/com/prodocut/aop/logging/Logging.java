package com.prodocut.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);

    @Pointcut(value = "execution(* com.prodocut.*.*.*(..) )")
    public void myPointCut() {
    }

    @Before("myPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Before " + joinPoint.getSignature().getName() + " method execution");

    }

    @After("myPointCut()")
    public void logAfterd(JoinPoint joinPoint) {
        logger.info("After " + joinPoint.getSignature().getName() + " method execution");
    }

    @AfterThrowing(pointcut = "myPointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in " + joinPoint.getSignature().toShortString(), exception);
    }
}
