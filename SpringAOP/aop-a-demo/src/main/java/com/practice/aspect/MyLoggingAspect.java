package com.practice.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect
{
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice()
    {
        System.out.println("Doing @Before advice on addAccount()");
    }


    @Before("execution(public void com.practice.dao.MembershipDAO.addAccount())")
    public void beforeSpecificAddAccountAdvice()
    {
        System.out.println("Doing @Before advice on specific addAccount()");
    }


    @Before("execution(public void add*())")
    public void beforeAnyAdd()
    {
        System.out.println("Doing @Before advice on any add*()");
    }


    @Before("execution(public * add*())")
    public void beforeAnyReturnAnyAdd()
    {
        System.out.println("Doing @Before advice on any add* and any return type()");
    }


    @Before("execution(public void add*(com.practice.aop.Account))")
    public void beforeAnyAddWithParameterAccount()
    {
        System.out.println("Doing @Before advice on any add*() with parameter Account");
    }


    @Before("execution(public void add*(com.practice.aop.Account, ..))")
    public void beforeAnyAddWithParameterAccountAndAnyNumberOfParameters()
    {
        System.out.println("Doing @Before advice on any add*() with parameter Account and any number of parameters");
    }


    @Before("execution(public void add*(..))")
    public void beforeAnyAddWithAnyNumberOfParameters()
    {
        System.out.println("Doing @Before advice on any add*() with any number of parameters");
    }


    @Before("execution(public * com.practice.dao.*.*(..))")
    public void beforeAnyAddFromDAOPackageAnyClassAnyMethodWithAnyNumberOfParameters()
    {
        System.out.println("Doing @Before advice on any add*() From any class in com.practice.dao Package Any method with any number of parameters");
    }


    @Before("execution(public * com.practice.aspect.*.*(..))")
    public void beforeAnyAddFromDAOPackageAnyClassAnyMethodWithAnyNumberOfParameters2()
    {
        System.out.println("Doing @Before advice on any add*() From any class in com.practice.aspect Package Any method with any number of parameters");
    }
}
