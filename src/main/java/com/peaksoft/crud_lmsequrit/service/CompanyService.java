package com.peaksoft.crud_lmsequrit.service;


import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompany();
    void addCompany(Company company);
    void updateCompany(long id,Company company);
    Company getById(long id);
    void deleteCompany(Company company);
    List<Course>getCoursesById(long id);
    List<Student> getStudentsById(Long id);
}
