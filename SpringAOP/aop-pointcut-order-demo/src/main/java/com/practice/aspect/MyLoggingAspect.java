package com.practice.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect
{


    @Before("com.practice.aspect.MyAopExpressions.forDAOPackageNoSetterNoGetter()")
    public void beforeAnyAdd()
    {
        System.out.println("-------->  Doing @Before advice on any add*(); no setter and no getter");
    }


}
