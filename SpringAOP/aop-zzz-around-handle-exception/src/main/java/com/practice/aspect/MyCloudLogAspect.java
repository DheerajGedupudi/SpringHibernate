package com.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect
{
    @Before("com.practice.aspect.MyAopExpressions.forDAOPackageNoSetterNoGetter()")
    public void doingAPIWorkNoSetterNoGetter()
    {
        System.out.println("-------->  Logging to cloud(); No Setter And No Getter");
    }
}
