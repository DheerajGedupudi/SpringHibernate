package com.example.noxml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class MyConfig
{
    @Bean
    public FortuneService sadFortuneService()
    {
        return new SadFortuneService();
    }

    //define bean for swimCoach and inject dependency
    @Bean
    public Coach swimCoach()
    {
        return  new SwimCoach(sadFortuneService());
    }
}
