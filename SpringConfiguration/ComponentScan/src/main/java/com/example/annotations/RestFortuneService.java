package com.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class RestFortuneService implements FortuneService
{

    @Override
    public String getMyFortune() {
        return "Take rest.";
    }
}
