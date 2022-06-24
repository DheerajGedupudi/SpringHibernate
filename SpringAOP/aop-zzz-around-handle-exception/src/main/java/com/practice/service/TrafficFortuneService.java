package com.practice.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService
{
    public String getFortune()
    {
        try
        {
            TimeUnit.SECONDS.sleep(5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return "Heavy Traffic";
    }

    public String getFortune(boolean tripWire)
    {
        if (tripWire)
        {
            throw  new RuntimeException("Accident occurred. Highway will be closed");
        }

        return getFortune();
    }
}
