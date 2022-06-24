package com.practice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HappyController
{
    @RequestMapping("/showForm")
    public String displayForm()
    {
        return "happy";
    }
}
