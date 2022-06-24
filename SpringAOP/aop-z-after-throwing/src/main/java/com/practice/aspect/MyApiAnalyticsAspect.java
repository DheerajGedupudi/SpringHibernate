package com.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect
{
    @Before("com.practice.aspect.MyAopExpressions.forDAOPackage()")
    public void doingAPIWork()
    {
        System.out.println("-------->  Doing API Work()");
    }
}
