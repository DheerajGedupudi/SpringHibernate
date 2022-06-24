package com.practice.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect
{

    @Pointcut("execution(public * com.practice.dao.*.*(..))")
    private void forDAOPackage()
    {

    }

    @Before("forDAOPackage()")
    public void beforeAnyAdd()
    {
        System.out.println("-------->  Doing @Before advice on any add*()");
    }

    @Before("forDAOPackage()")
    public void doingAPIWork()
    {
        System.out.println("-------->  Doing API Work()");
    }

}
