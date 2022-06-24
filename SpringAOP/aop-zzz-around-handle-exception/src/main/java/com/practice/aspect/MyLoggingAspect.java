package com.practice.aspect;


import com.practice.aop.Account;
import com.practice.aop.AroundWithLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect
{

    private static Logger myLogger = Logger.getLogger(AroundWithLogger.class.getName());

    @Before("com.practice.aspect.MyAopExpressions.forDAOPackageNoSetterNoGetter()")
    public void beforeAnyAdd(JoinPoint myJoinPoint)
    {
        myLogger.info("-------->  Doing @Before advice on any method(); no setter and no getter");

        MethodSignature methodSignature = (MethodSignature) myJoinPoint.getSignature();

        myLogger.info("Method Signature : "+methodSignature);

        //getting args

        Object[] args = myJoinPoint.getArgs();

        for (Object arg : args)
        {
            myLogger.info(arg.toString());

            if (arg instanceof Account)
            {
                //downcast and print details
                Account myAccount = (Account) arg;

                myLogger.info("acc name : "+myAccount.getName());
                myLogger.info("acc level : "+myAccount.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.practice.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccounts(JoinPoint myJoinPoint, List<Account> result)
    {
        String method = myJoinPoint.getSignature().toShortString();

        myLogger.info("====> AfterReturning on method : "+method);

        myLogger.info("====> result is : "+result);

        //lets modify the details
        modifyAccountDetails(result);

        myLogger.info("====> modified result is : "+result);
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

        myLogger.info("====> AfterThrowing on method : "+method);

        myLogger.info("====> The Exception is : "+myExc);

    }

    @After("execution(* com.practice.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccount(JoinPoint myJoinPoint)
    {
        String method = myJoinPoint.getSignature().toShortString();

        myLogger.info("====> AfterFinally on method : "+method);
    }

    @Around("execution(* com.practice.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint myProceedingJoinPoint) throws Throwable
    {
        String method = myProceedingJoinPoint.getSignature().toShortString();

        myLogger.info("====> @Around on method : "+method);

        long begin = System.currentTimeMillis();

        Object result = null;

        try
        {
            result = myProceedingJoinPoint.proceed();
        }
        catch (Exception e)
        {
            myLogger.warning(e.getMessage());

            //re-throw
            throw e;

            //custom handling of exception
//            result = "Accident has occurred. Help is on the way";
        }

        long end = System.currentTimeMillis();

        double time = (double)(end-begin)/1000;

        myLogger.info("=======> The time take is : "+time+" seconds");

        return result;
    }

}
