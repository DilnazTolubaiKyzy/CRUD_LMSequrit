package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("select s from Student s join s.group g join g.courses c join c.teachers t where t.id=:id")
    List<Student> getStudentsById(@Param("id") long id);
    @Query("select c from Course c join c.teachers tea where tea.id=:id")
    Course getCourseById(@Param("id") Long id);
}
