package com.practice.aop;

import com.practice.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class NoExcStillFinally
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO myAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        myAccountDAO.addAccount();

        List<Account> myAccounts = null;

        try
        {
            boolean tripWire = false;
            myAccounts = myAccountDAO.findAccounts(tripWire);
        }
        catch (Exception e)
        {
            System.out.println("\nIn Main Program : caught exception : "+e);
        }

        System.out.println("\nMain Program : AfterThrowing Main 2");
        System.out.println(myAccounts+"\n");

        context.close();
    }
}
