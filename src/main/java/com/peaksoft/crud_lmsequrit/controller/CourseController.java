package com.peaksoft.crud_lmsequrit.controller;

import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import com.peaksoft.crud_lmsequrit.service.CompanyService;
import com.peaksoft.crud_lmsequrit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("courses")
public class CourseController {
    private final CourseService courseService;
    private final CompanyService companyService;
    @Autowired
    public CourseController(CourseService courseService,CompanyService companyService) {
        this.courseService = courseService;
        this.companyService = companyService;
    }

    @GetMapping
    public String courses(Model model){
        model.addAttribute("courses",courseService.getAllCourse());
        return "course/courses";
    }

    @GetMapping("/addCourse")
    public String add(Model model){
        model.addAttribute("course",new Course());
        model.addAttribute("companies",companyService.getAllCompany());
        return "course/addCourse";
    }

    @PostMapping("/saveCourse")
    public String save(@ModelAttribute("course") Course course){
        courseService.addCourse(course,course.getCompanyId());
        return "redirect:/courses";
    }
   // value = "/{id}", method = RequestMethod.POST
   @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
       Course course= courseService.getById(id);
        List<Company> companies = companyService.getAllCompany();
        model.addAttribute("course" ,course );
        model.addAttribute("companies",companies);
        return "course/updateCourse";
   }

   @RequestMapping (value = "/{id}",method = RequestMethod.POST)
    public String updateCourse(@PathVariable("id") Long id,@ModelAttribute("course") Course course){
        courseService.updateCourse(id,course,course.getCompanyId());
       return "redirect:/courses";
   }
    @GetMapping("/groups/{id}")
    public String getGroups(@PathVariable("id") Long id,Model model){
        List<Group> groups = courseService.getGroupById(id);
        model.addAttribute("groups",groups);
        return "course/groups";
    }
    @GetMapping("/teachers/{id}")
    public String getCourses(@PathVariable("id") Long id,Model model){
        List<Teacher> teachers = courseService.getTeacherById(id);
        model.addAttribute("teachers",teachers);
        return "course/teachers";
    }

    @GetMapping("/companies/{id}")
    public String getCompany(@PathVariable("id") Long id,Model model){
        Company company = courseService.getCompanyById(id);
        model.addAttribute("company", company);
        return "course/company";
    }
   @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id){
        Course course = courseService.getById(id);
        courseService.deleteCourse(course);
       return "redirect:/courses";
   }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
