package com.practice.aop;

import com.practice.dao.AccountDAO;
import com.practice.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main2App
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO myAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        myAccountDAO.addAccount();

        List<Account> myAccounts = myAccountDAO.findAccounts();

        System.out.println("\n Main Program : AfterReturning Main 2");
        System.out.println(myAccounts+"\n");

        context.close();
    }
}
