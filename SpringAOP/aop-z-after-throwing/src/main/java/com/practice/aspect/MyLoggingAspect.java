package com.practice.aspect;


import com.practice.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect
{


    @Before("com.practice.aspect.MyAopExpressions.forDAOPackageNoSetterNoGetter()")
    public void beforeAnyAdd(JoinPoint myJoinPoint)
    {
        System.out.println("-------->  Doing @Before advice on any method(); no setter and no getter");

        MethodSignature methodSignature = (MethodSignature) myJoinPoint.getSignature();

        System.out.println("Method Signature : "+methodSignature);

        //getting args

        Object[] args = myJoinPoint.getArgs();

        for (Object arg : args)
        {
            System.out.println(arg);

            if (arg instanceof Account)
            {
                //downcast and print details
                Account myAccount = (Account) arg;

                System.out.println("acc name : "+myAccount.getName());
                System.out.println("acc level : "+myAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.practice.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccounts(JoinPoint myJoinPoint, List<Account> result)
    {
        String method = myJoinPoint.getSignature().toShortString();

        System.out.println("====> AfterReturning on method : "+method);

        System.out.println("====> result is : "+result);

        //lets modify the details
        modifyAccountDetails(result);

        System.out.println("====> modified result is : "+result);
    }

    private void modifyAccountDetails(List<Account> result)
    {
        for (Account acc : result)
        {
            String name = acc.getName().toUpperCase();

            acc.setName(name);
            acc.setLevel("Beginner");
        }
    }

    @AfterThrowing(pointcut = "execution(* com.practice.dao.AccountDAO.findAccounts(..))", throwing = "myExc")
    public void AfterThrowingFindAccount(JoinPoint myJoinPoint, Throwable myExc)
    {
        String method = myJoinPoint.getSignature().toShortString();

        System.out.println("====> AfterThrowing on method : "+method);

        System.out.println("====> The Exception is : "+myExc);

    }


}
