package com.practice.aspect;


import com.practice.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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


}
