package com.peaksoft.crud_lmsequrit.service.impl;
import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import com.peaksoft.crud_lmsequrit.repository.CompanyRepository;
import com.peaksoft.crud_lmsequrit.repository.CourseRepository;
import com.peaksoft.crud_lmsequrit.service.CourseService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

   private final CourseRepository courseRepository;
   private final CompanyRepository companyRepository;

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    @Override
    public void addCourse(Course course,Long companyId) {
        Company company = companyRepository.getById(companyId);
        course.setCompany(company);
     courseRepository.save(course);
    }

    @Override
    public void updateCourse(long id, Course course,Long companyId) {
        Company company = companyRepository.getById(companyId);
        Course course1 = courseRepository.getById(id);
        course1.setCourseName(course.getCourseName());
        course1.setDurationMonth(course.getDurationMonth());
        course1.setCompany(company);
        courseRepository.save(course1);

    }

    @Override
    public Course getById(long id) {
        return courseRepository.getById(id);
    }

    @Override
    public void deleteCourse(Course course) {
     courseRepository.delete(course);
    }

    @Override
    public List<Group> getGroupById(Long id) {
       return courseRepository.getGroupById(id);
    }

    @Override
    public List<Teacher> getTeacherById(Long id) {
        return courseRepository.getTeacherById(id);
    }

    @Override
    public Company getCompanyById(Long id) {
        return courseRepository.getCompanyById(id);
    }
}
