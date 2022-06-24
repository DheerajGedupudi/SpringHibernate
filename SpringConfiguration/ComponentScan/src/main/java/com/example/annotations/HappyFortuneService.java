package com.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService
{
    @Override
    public String getMyFortune() {
        return "Tomorrow is your luck day";
    }
}
