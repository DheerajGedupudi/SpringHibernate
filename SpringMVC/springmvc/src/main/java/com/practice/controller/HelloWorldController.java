package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController
{
    @RequestMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm()
    {
        return "helloworld";
    }

    @RequestMapping("/processFormVersion2")
    public String letsShout(HttpServletRequest request, Model model )
    {
        String theName = request.getParameter("studentName");

        String reversedName = new StringBuilder(theName).reverse().toString();

        String result = "reversed! " + reversedName;

        model.addAttribute("message", result);

        return "helloworld";
    }

    @RequestMapping("/processFormVersion3")
    public String letsShout(@RequestParam("studentName") String theName, Model model )
    {

        theName = theName.toUpperCase();

        String result = "Capitalized! " + theName;

        model.addAttribute("message", result);

        return "helloworld";
    }

}
