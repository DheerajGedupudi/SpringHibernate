package com.example.demo;

public class CricketCoach implements Coach
{

    private FortuneService fortuneService;

    public CricketCoach(FortuneService theFortuneService)
    {
        fortuneService = theFortuneService;
    }

    private String emailId;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        System.out.println("In CricketCoach: inside setEmailId()");
        this.emailId = emailId;
    }

    private String team;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        System.out.println("In CricketCoach: inside setTeam()");
        this.team = team;
    }

    @Override
    public String getMyWorkout()
    {
        return "Spend 30 minutes on bowling practice";
    }

    @Override
    public String getMyFortune() {
        return fortuneService.getFortune();
    }
}
