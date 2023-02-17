package com.peaksoft.crud_lmsequrit.controller;

import com.peaksoft.crud_lmsequrit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HelloController {
    private final UserService userService;
    @GetMapping
    public String hello(){
        return "hello";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model){
        Principal principal = request.getUserPrincipal();
        model.addAttribute("user",userService.getUserByEmail(principal.getName()));
        return "profile";
    }
}
