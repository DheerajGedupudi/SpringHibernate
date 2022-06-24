package com.practice.aop;

import com.practice.dao.AccountDAO;
import com.practice.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO myAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        myAccountDAO.addAccount();

        MembershipDAO myMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        myMembershipDAO.addAccount();

        myMembershipDAO.addMember();

        //boolean return type
        myMembershipDAO.addRandom();

        //check for parameter @before
        Account myAccount = new Account();
        myAccountDAO.addAccount(myAccount);

        boolean isVIP = true;
        myAccountDAO.addAccount(myAccount, isVIP);

        myMembershipDAO.removeAccount();

        context.close();
    }
}
