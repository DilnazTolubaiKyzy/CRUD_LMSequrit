package com.peaksoft.crud_lmsequrit.service.impl;

import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.repository.GroupRepository;
import com.peaksoft.crud_lmsequrit.repository.StudentRepository;
import com.peaksoft.crud_lmsequrit.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;


    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student, Long groupId) {
         Group group =groupRepository.getById(groupId);
         student.setGroup(group);
      studentRepository.save(student);
    }

    @Override
    public void updateStudent(long id, Student student,Long groupId) {
        Group group = groupRepository.getById(groupId);
       Student student1 = studentRepository.getById(id);
       student1.setFirstName(student.getFirstName());
       student1.setLastName(student.getLastName());
       student1.setEmail(student.getEmail());
       student1.setStudyFormat(student.getStudyFormat());
       student1.setGroup(group);
       studentRepository.save(student1);
    }

    @Override
    public Student getById(long id) {
        return studentRepository.getById(id);
    }

    @Override
    public void deleteStudent(Student student) {
     studentRepository.delete(student);
    }

    @Override
    public Group getGroupById(Long id) {
       return studentRepository.getGroupById(id);
    }
}
