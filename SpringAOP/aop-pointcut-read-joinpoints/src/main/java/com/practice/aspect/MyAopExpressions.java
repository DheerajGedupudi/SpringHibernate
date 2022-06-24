package com.practice.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAopExpressions
{
    @Pointcut("execution(public * com.practice.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(public * com.practice.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(public * com.practice.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDAOPackageNoSetterNoGetter() {}
}
