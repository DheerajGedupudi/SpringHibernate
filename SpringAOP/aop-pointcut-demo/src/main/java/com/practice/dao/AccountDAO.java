package com.practice.dao;

import com.practice.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{
    public void addAccount()
    {
        System.out.println(getClass()+" Adding an account\n");
    }


    public void addAccount(Account myAccount)
    {
        System.out.println(getClass()+" Adding an account with parameter Account\n");
    }


    public void addAccount(Account myAccount, boolean isVIP)
    {
        System.out.println(getClass()+" Adding an account with parameter Account and boolean isVIP \n");
    }
}
