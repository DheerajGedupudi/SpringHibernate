package com.practice.aop;

import com.practice.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleException
{
    private static Logger myLogger = Logger.getLogger(AroundHandleException.class.getName());
    
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService myFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program : AroundDemo");

        myLogger.info("Calling getFortune");

        boolean tripWire = true;
        String data = myFortuneService.getFortune(tripWire);

        myLogger.info("\nThe Fortune is : "+data);

        myLogger.info("Done");

        context.close();
    }
}
