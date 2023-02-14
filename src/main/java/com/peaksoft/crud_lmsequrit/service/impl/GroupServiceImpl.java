package com.peaksoft.crud_lmsequrit.service.impl;

import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.repository.CourseRepository;
import com.peaksoft.crud_lmsequrit.repository.GroupRepository;
import com.peaksoft.crud_lmsequrit.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
      private final GroupRepository groupRepository;
      private final CourseRepository courseRepository;

    @Override
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public void addGroup(Group group,Long courseId) {
        Course course = courseRepository.getById(courseId);
        List<Course> courses = new ArrayList<>();
        courses.add(course);
        group.setCourses(courses);
    groupRepository.save(group);
    }

    @Override
    public void updateGroup(long id, Group group,Long courseId) {
       Group group1 = groupRepository.getById(id);
       group1.setGroupName(group.getGroupName());
       group1.setStudents(group.getStudents());
       group1.setDateOfFinish(group.getDateOfFinish());
       group1.setDateOfStart(group.getDateOfStart());
       groupRepository.save(group1);
    }

    @Override
    public Group getById(long id) {
        return groupRepository.getById(id);
    }

    @Override
    public void deleteGroup(Group group) {
       groupRepository.delete(group);
    }

    @Override
    public List<Student> getStudentsByGroupId(Long id) {
        return groupRepository.getStudentsByGroupId(id);
    }

    @Override
    public List<Student> search(Long id,String firstName) {
        return groupRepository.search(id,firstName);
    }

    @Override
    public List<Course> getCoursesById(Long id) {
        return groupRepository.getCoursesById(id);
    }
}
