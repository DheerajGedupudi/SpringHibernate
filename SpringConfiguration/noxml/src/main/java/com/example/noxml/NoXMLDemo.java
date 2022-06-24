package com.example.noxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NoXMLDemo
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        SwimCoach myCoach = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(myCoach.getMyWorkout());

        System.out.println(myCoach.getMyFortune());

        System.out.println("email : "+myCoach.getEmail());

        System.out.println("team : "+myCoach.getTeam());

        context.close();
    }
}
