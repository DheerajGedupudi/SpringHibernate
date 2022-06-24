package com.example.demo;

public class TrackCoach implements Coach
{

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getMyWorkout() {
        return "Run 5km";
    }

    @Override
    public String getMyFortune() {
        return "Do it now: "+fortuneService.getFortune();
    }

    public void doWhenStartup()
    {
        System.out.println("TrackCoach : inside doWhenStartup()");
    }

    public void doWhenDestroy()
    {
        System.out.println("TrackCoach : inside doWhenDestroy()");
    }
}
