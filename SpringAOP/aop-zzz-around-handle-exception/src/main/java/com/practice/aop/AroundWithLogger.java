package com.practice.aop;

import com.practice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLogger
{
    private static Logger myLogger = Logger.getLogger(AroundWithLogger.class.getName());
    
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService myFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program : AroundDemo");

        myLogger.info("Calling getFortune");

        String data = myFortuneService.getFortune();

        myLogger.info("\nThe Fortune is : "+data);

        myLogger.info("Done");

        context.close();
    }
}
