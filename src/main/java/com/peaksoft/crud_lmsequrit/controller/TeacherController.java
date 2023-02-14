package com.peaksoft.crud_lmsequrit.controller;

import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import com.peaksoft.crud_lmsequrit.service.CourseService;
import com.peaksoft.crud_lmsequrit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;
    @Autowired
    public TeacherController(TeacherService teacherService,CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @GetMapping
    public String teachers(Model model){
        model.addAttribute("teachers",teacherService.getAllTeacher());
        return "teacher/teachers";
    }

    @GetMapping("/addTeacher")
    public String add(Model model){
        model.addAttribute("teacher",new Teacher());
        model.addAttribute("courses",courseService.getAllCourse());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String save(@ModelAttribute("teacher") Teacher teacher){
        teacherService.addTeacher(teacher, teacher.getCourseId());
        return "redirect:/teachers";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, Model model){
        Teacher teacher = teacherService.getById(id);
        List<Course> courses = courseService.getAllCourse();
        model.addAttribute("teacher" ,teacher );
        model.addAttribute("courses",courses);
        return "teacher/updateTeacher";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public String updateTeacher(@PathVariable("id") Long id,@ModelAttribute("course") Teacher teacher){
        teacherService.updateTeacher(id,teacher, teacher.getCourseId());
        return "redirect:/teachers";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id){
        Teacher teacher = teacherService.getById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/students/{id}")
    public String getStudents(@PathVariable("id") Long id, Model model){
        List<Student> students = teacherService.getStudentsById(id);
        model.addAttribute("students",students);
        model.addAttribute("size",students.size());
        return "teacher/students";
    }

    @GetMapping("/courses/{id}")
    public String getCourse(@PathVariable("id") Long id,Model model){
        Course course = teacherService.getCourseById(id);
        model.addAttribute("course", course);
        return "teacher/course";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
