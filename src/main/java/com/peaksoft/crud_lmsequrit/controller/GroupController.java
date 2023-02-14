package com.peaksoft.crud_lmsequrit.controller;


import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.service.CourseService;
import com.peaksoft.crud_lmsequrit.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;
    @Autowired
    public GroupController(GroupService groupService,CourseService courseService) {
        this.groupService = groupService;
        this.courseService = courseService;
    }

    @GetMapping
    public String groups(Model model){
        model.addAttribute("groups",groupService.getAllGroup());
        return "group/groups";
    }

    @GetMapping("/addGroup")
    public String add(Model model){
        model.addAttribute("group",new Group());
        model.addAttribute("courses",courseService.getAllCourse());
        return "group/addGroup";
    }

    @PostMapping("/saveGroup")
    public String save(@ModelAttribute("group") Group group){
        groupService.addGroup(group,group.getCourseId());
        return "redirect:/groups";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Group group = groupService.getById(id);
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("group" ,group );
        model.addAttribute("courses",courses);
        return "group/updateGroup";
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String updateGroup(@PathVariable("id") Long id,@ModelAttribute("group") Group group){
        groupService.updateGroup(id,group,group.getCourseId());
        return "redirect:/groups";
    }
    @GetMapping("/students/{id}")
    public String students(@PathVariable("id") Long id, Model model,@ModelAttribute("student")Student student){
        List<Student>students = groupService.getStudentsByGroupId(id);
        model.addAttribute("group",groupService.getById(id));
        model.addAttribute("students",students);
        return "group/students";
    }
    @GetMapping("/search/{id}")
    public String search(@PathVariable("id") Long id, Model model,@RequestParam("firstName")String firstName){
        List<Student>students = groupService.search(id,firstName);
        model.addAttribute("students",students);
        return "group/search";
    }
    @GetMapping("/courses/{id}")
    public String getCourses(@PathVariable("id") Long id,Model model){
        List<Course> courses = groupService.getCoursesById(id);
        model.addAttribute("courses" ,courses);
        return "group/courses";
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id){
        Group group = groupService.getById(id);
        groupService.deleteGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
