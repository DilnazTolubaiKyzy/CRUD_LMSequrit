package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Group;
import com.peaksoft.crud_lmsequrit.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query(" select g from Group g join g.courses cou where cou.id=:id")
    List<Group> getGroupById(@Param("id") Long id);
    @Query(" select t from Teacher t join t.course cou where cou.id=:id")
    List<Teacher> getTeacherById(@Param("id") Long id);
    @Query("select c from Company c join c.courses cou where cou.id = :id")
    Company getCompanyById(@Param("id") Long id);
}
