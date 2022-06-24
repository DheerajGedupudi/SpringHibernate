package com.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("theBadmintonMaster")
@Scope("prototype")
public class BadmintonCoach implements Coach
{

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    public BadmintonCoach()
    {
        System.out.println("BadmintonCoach : Inside the default constructor");
    }

//   @Autowired
//   public void setFortuneService(FortuneService theFortuneService)
//   {
//       System.out.println("BadmintonCoach : Inside setFortuneService()");
//       fortuneService = theFortuneService;
//   }

    @PostConstruct
    public void atStart()
    {
        System.out.println("BadmintonCoach : Inside atStart(), after creating a new BadmintonCoach");
    }

    @PreDestroy
    public void atEnd()
    {
        System.out.println("BadmintonCoach : Inside atEnd(), before destroying the BadmintonCoach");
    }

    @Override
    public String getMyWorkout() {
        return "Practice Badminton";
    }

    @Override
    public String getMyFortune() {
        return fortuneService.getMyFortune();
    }
}
