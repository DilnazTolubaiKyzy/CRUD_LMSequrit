package com.peaksoft.crud_lmsequrit.service;


import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroup();
    void addGroup(Group group,Long courseId);
    void updateGroup(long id,Group group,Long courseId);
    Group getById(long id);
    void deleteGroup( Group group);
    List<Student> getStudentsByGroupId(Long id);
    List<Student> search(Long id,String FirstName);
    List<Course> getCoursesById(Long id);
}
