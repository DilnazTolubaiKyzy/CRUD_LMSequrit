package com.peaksoft.crud_lmsequrit.service;


import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeacher();
    void addTeacher(Teacher teacher,Long courseId);
    void updateTeacher(long id ,Teacher teacher,Long courseId);
    Teacher getById(long id);
    void deleteTeacher(Teacher teacher);
    List<Student> getStudentsById(Long id);

    Course getCourseById(Long id);
}
