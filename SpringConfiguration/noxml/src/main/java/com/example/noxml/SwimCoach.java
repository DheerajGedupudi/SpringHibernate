package com.example.noxml;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach
{
    @Value("${hey.email}")
    private String email;

    @Value("${hey.team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService)
    {
        fortuneService = theFortuneService;
    }
    @Override
    public String getMyWorkout() {
        return "Practice Butterfly 2 laps";
    }

    @Override
    public String getMyFortune() {
        return fortuneService.getMyFortune();
    }


    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }


}
