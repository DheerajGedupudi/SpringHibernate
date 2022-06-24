package com.practice.aop;

import com.practice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemo
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService myFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program : AroundDemo");

        System.out.println("Calling getFortune");

        String data = myFortuneService.getFortune();

        System.out.println("\nThe Fortune is : "+data);

        System.out.println("Done");

        context.close();
    }
}
