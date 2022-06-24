package com.practice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect
{
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.practice.controller.*.*(..))")
    private void forControllerPackage() {}


    @Pointcut("execution(* com.practice.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.practice.dao.*.*(..))")
    private void forDAOPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forApplicationFlow() {}

    //Before

    @Before("forApplicationFlow()")
    public void before(JoinPoint myJoinPoint)
    {
        String myMethod = myJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @Before : method called : "+myMethod);

        Object[] args = myJoinPoint.getArgs();

        for (Object arg : args)
        {
            myLogger.info("========> argument passed : "+arg);
        }
    }

    @AfterReturning(pointcut = "forApplicationFlow()", returning = "myResult")
    public void afterReturning(JoinPoint myJoinPoint, Object myResult)
    {
        String myMethod = myJoinPoint.getSignature().toShortString();
        myLogger.info("=====> in @AfterReturning : method called : "+myMethod);

        myLogger.info("=====> The Result is : "+myResult);
    }
}
