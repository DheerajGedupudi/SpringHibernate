package com.example.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeDemo
{
    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");

        Coach coach1 = context.getBean("myCoach", Coach.class);

        Coach coach2 = context.getBean("myCoach", Coach.class);

        System.out.println("Same Objects ? : "+(coach1==coach2));

        System.out.println("Memory Location for coach1 : "+coach1);

        System.out.println("Memory Location for coach2 : "+coach2);

        context.close();
    }
}
