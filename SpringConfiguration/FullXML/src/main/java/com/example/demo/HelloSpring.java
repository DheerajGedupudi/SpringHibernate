package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring
{
    public static  void main(String[] args)
    {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCoach myCoach = context.getBean("myCoach", CricketCoach.class);

        System.out.println(myCoach.getMyWorkout());

        System.out.println(myCoach.getMyFortune());

        System.out.println(myCoach.getEmailId());

        System.out.println(myCoach.getTeam());

        context.close();
    }
}
