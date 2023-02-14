package com.peaksoft.crud_lmsequrit.service;

import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    void addStudent(Student student, Long groupId);
    void updateStudent(long id,Student student,Long groupId);
    Student getById(long id);
    void deleteStudent(Student student);
    Group getGroupById(Long id);
}
