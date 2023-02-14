package com.peaksoft.crud_lmsequrit.controller;


import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("companies")
public class CompanyController {

    private final CompanyService companyService;
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
    public String  companies(Model model){
        model.addAttribute("companies",companyService.getAllCompany());
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String add(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String save(@ModelAttribute("company") Company company){
        companyService.addCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id,Model model){
        Company company = companyService.getById(id);
        model.addAttribute("company",company);
        return "company/updateCompany";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateCompany(@PathVariable("id")Long  id,@ModelAttribute("company")Company company){
        companyService.updateCompany(id,company);
        return "redirect:/companies";
    }

   @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id ){
        Company company = companyService.getById(id);
        companyService.deleteCompany(company);
        return "redirect:/companies";
    }
    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id") Long id,Model model){
        List<Course> courses = companyService.getCoursesById(id);
        model.addAttribute("courses",courses);
        return "company/courses";
    }
    @GetMapping("/students/{id}")
    public String getStudents(@PathVariable("id") Long id, Model model){
        List<Student> students = companyService.getStudentsById(id);
        model.addAttribute("students",students);
        model.addAttribute("size",students.size());
        return "company/students";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
