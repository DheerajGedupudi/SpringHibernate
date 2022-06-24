package com.example.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompScanDemo
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach myCoach = context.getBean("theBadmintonMaster", Coach.class);

        Coach myCoach2 = context.getBean("theBadmintonMaster", Coach.class);

        System.out.println("Same objects ? = "+(myCoach==myCoach2));

        System.out.println(myCoach.getMyWorkout());

        System.out.println(myCoach.getMyFortune());

        context.close();
    }
}
