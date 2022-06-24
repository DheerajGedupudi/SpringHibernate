package com.example.demo;

public class MyApp
{
    public static void main(String[] args)
    {
        FortuneService myFortuneService = new HappyFortuneService();

        Coach myCoach = new CricketCoach(myFortuneService);

        System.out.println(myCoach.getMyWorkout());

        System.out.println(myCoach.getMyFortune());
    }
}
