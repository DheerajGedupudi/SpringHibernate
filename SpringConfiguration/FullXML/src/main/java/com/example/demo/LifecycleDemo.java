package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifecycleDemo
{
    public static void main(String args[])
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");

        Coach myCoach = context.getBean("myCoach", Coach.class);

        System.out.println(myCoach.getMyWorkout());

        context.close();
    }
}
