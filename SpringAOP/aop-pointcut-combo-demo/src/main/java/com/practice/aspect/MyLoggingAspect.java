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
    private void forDAOPackage() {}

    @Pointcut("execution(public * com.practice.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(public * com.practice.dao.*.set*(..))")
    private void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoSetterNoGetter() {}

//    @Before("forDAOPackage()")
//    public void beforeAnyAdd()
//    {
//        System.out.println("-------->  Doing @Before advice on any add*()");
//    }

    @Before("forDAOPackage()")
    public void doingAPIWork()
    {
        System.out.println("-------->  Doing API Work()");
    }


    @Before("forDAOPackageNoSetterNoGetter()")
    public void doingAPIWorkNoSetterNoGetter()
    {
        System.out.println("-------->  Doing API Work() No Setter And No Getter");
    }

}
