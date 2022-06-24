package com.example.demo;

public class HappyFortuneService implements FortuneService
{
    @Override
    public String getFortune() {
        return "Today happens to be your lucky day";
    }
}
