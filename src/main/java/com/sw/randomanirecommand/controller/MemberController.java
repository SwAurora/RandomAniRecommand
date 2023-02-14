package com.sw.randomanirecommand.controller;

import com.sw.randomanirecommand.domain.Member;
import com.sw.randomanirecommand.domain.MemberForm;
import com.sw.randomanirecommand.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController
{
    private final MemberService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login()
    {
        return "member/login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model)
    {
        model.addAttribute("memberForm", new MemberForm());
        return "member/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@Validated MemberForm memberForm, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "member/signUp";
        }
        try
        {
            Member member = Member.createMember(memberForm, passwordEncoder);
            service.saveMember(member);
        }
        catch(IllegalStateException e)
        {
            model.addAttribute("errorMessage", e.getMessage());
            return "member/signUp";
        }

        return "redirect:/";
    }
}
