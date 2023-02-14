package com.peaksoft.crud_lmsequrit.controller;

import com.peaksoft.crud_lmsequrit.entity.Role;
import com.peaksoft.crud_lmsequrit.entity.User;
import com.peaksoft.crud_lmsequrit.repository.RoleRepository;
import com.peaksoft.crud_lmsequrit.repository.UserRepository;
import com.peaksoft.crud_lmsequrit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String users(Model model){
        model.addAttribute("users",userService.getAll());
        return "users";
    }
    @GetMapping("/saveUser")
    public String save(Model model){
        model.addAttribute("user",new User());
        return "saveUser";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.save(user,user.getRoleName());
        return "redirect:/users";

    }




}
