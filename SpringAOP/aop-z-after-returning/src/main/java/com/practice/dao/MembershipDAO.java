package com.practice.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO
{
    public void addAccount()
    {
        System.out.println(getClass()+" Adding a membership account\n");
    }


    public void addMember()
    {
        System.out.println(getClass()+" Adding a member\n");
    }


    public boolean addRandom()
    {
        System.out.println(getClass()+" Adding random, return type is boolean\n");

        return true;
    }

    public void removeAccount()
    {
        System.out.println(getClass()+" Removing account, return void, name: removeAccount()\n");
    }
}
