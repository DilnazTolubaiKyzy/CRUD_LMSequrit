package com.peaksoft.crud_lmsequrit.service.impl;

import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import com.peaksoft.crud_lmsequrit.repository.CourseRepository;
import com.peaksoft.crud_lmsequrit.repository.TeacherRepository;
import com.peaksoft.crud_lmsequrit.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher,Long courseId) {
        Course course  = courseRepository.getById(courseId);
        teacher.setCourse(course);
     teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(long id, Teacher teacher,Long courseId) {
        Course course = courseRepository.getById(courseId);
       Teacher teacher1 = teacherRepository.getById(id);
       teacher1.setFirstName(teacher.getFirstName());
       teacher1.setLastName(teacher.getLastName());
       teacher1.setEmail(teacher.getEmail());
       teacher1.setCourse(course);
       teacherRepository.save(teacher1);
    }

    @Override
    public Teacher getById(long id) {
        return teacherRepository.getById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
     teacherRepository.delete(teacher);
    }

    @Override
    public List<Student> getStudentsById(Long id) {
        return teacherRepository.getStudentsById(id);
    }

    @Override
    public Course getCourseById(Long id) {
        return teacherRepository.getCourseById(id);
    }

}
