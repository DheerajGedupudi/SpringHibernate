package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach
{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService theFortuneService)
//    {
//        fortuneService = theFortuneService;
//    }

    @Override
    public String getMyWorkout() {
        return "Practice Tennis";
    }

    @Override
    public String getMyFortune() {
        return fortuneService.getMyFortune();
    }
}
