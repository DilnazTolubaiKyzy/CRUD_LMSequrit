package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
     @Query("select s from Student s join s.group gro where gro.id=:id")
    List<Student> getStudentsByGroupId(@Param("id") Long id);
     @Query("select s from Student s join s.group gro where gro.id=:id and s.firstName=:firstName")
    List<Student> search(@Param("id") Long id,@Param("firstName") String firstName);
     @Query("select c from Course c join c.groups gr where gr.id=:id")
    List<Course> getCoursesById(@Param("id") Long id);
}
