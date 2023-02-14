package com.peaksoft.crud_lmsequrit.repository;

import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query(" select c from Course c join c.company com where com.id =:id")
    List<Course> getCoursesById(@Param("id") Long id);
    @Query("select s from Student s join s.group g join g.courses c join c.company com where com.id=:id")
    List<Student> getStudentsById(@Param("id") Long id);
}
