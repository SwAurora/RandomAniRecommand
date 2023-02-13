package com.sw.randomanirecommand.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    @GetMapping("/signUp")
    public String signUp()
    {
        return "signUp";
    }

    @GetMapping("/random")
    public String random(Model model)
    {

        model.addAttribute("", null);
        return "random";
    }
}