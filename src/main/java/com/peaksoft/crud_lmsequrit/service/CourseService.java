package com.peaksoft.crud_lmsequrit.service;


import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();
    void addCourse(Course course,Long companyId);
    void updateCourse(long id,Course course,Long companyId);
    Course getById(long id);
    void deleteCourse(Course course);

    List<Group> getGroupById(Long id);

    List<Teacher> getTeacherById(Long id);

    Company getCompanyById(Long id);
}
