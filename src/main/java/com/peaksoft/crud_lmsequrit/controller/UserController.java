package com.peaksoft.crud_lmsequrit.controller;

import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Role;
import com.peaksoft.crud_lmsequrit.entity.User;
import com.peaksoft.crud_lmsequrit.repository.RoleRepository;
import com.peaksoft.crud_lmsequrit.repository.UserRepository;
import com.peaksoft.crud_lmsequrit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.SecondaryTable;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Set;

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
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user" , user);
        return "updateUser";
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id")Long  id,@ModelAttribute("user") User user){
        userService.update(id,user,user.getRoleName());
        return "redirect:/users";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id ){
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/users";
    }
    @GetMapping("/roles/{id}")
    public String roles(@PathVariable("id") Long id,Model model){
       Set<Role>  roles = userService.getRolesByUserId(id);
        model.addAttribute("role" , roles);
        return "roles";
    }





}
