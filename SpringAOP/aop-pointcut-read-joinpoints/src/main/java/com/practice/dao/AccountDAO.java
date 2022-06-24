package com.practice.dao;

import com.practice.aop.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO
{

    private String name;

    private String serviceCode;

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

    public String getName() {
        System.out.println(getClass()+" inside getName() \n");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+" inside setName() \n");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass()+" inside getServiceCode() \n");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass()+" inside setServiceCode() \n");
        this.serviceCode = serviceCode;
    }
}
