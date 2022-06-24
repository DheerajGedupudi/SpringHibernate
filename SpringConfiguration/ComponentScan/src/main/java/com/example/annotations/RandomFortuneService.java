package com.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService
{
    private String[] fortunes = {
            "Good Day",
            "Bad Day",
            "Don't take rest",
            "Eat Chocolates",
            "Eat Biscuits"
    };

    @Override
    public String getMyFortune()
    {
        int random = (int)(Math.random()*fortunes.length);
        return fortunes[random];
    }
}
