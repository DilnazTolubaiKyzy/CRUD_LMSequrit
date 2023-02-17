package com.peaksoft.crud_lmsequrit.service.impl;

import com.peaksoft.crud_lmsequrit.entity.Company;
import com.peaksoft.crud_lmsequrit.entity.Course;
import com.peaksoft.crud_lmsequrit.entity.Student;
import com.peaksoft.crud_lmsequrit.repository.CompanyRepository;
import com.peaksoft.crud_lmsequrit.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    @Override
    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public void addCompany(Company company) {
     companyRepository.save(company);
    }

    @Override
    public void updateCompany(long id, Company company) {
     Company company1 = companyRepository.getById(id);
     company1.setCompanyName(company.getCompanyName());
     company1.setLocatedCountry(company.getLocatedCountry());
     companyRepository.save(company1);
    }

    @Override
    public Company getById(long id) {
        return companyRepository.getById(id);
    }

    @Override
    public void deleteCompany(Company company) {
    companyRepository.delete(company);
    }

    @Override
    public List<Course> getCoursesById(long id) {
        return companyRepository.getCoursesById(id) ;
    }

    @Override
    public List<Student> getStudentsById(Long id) {
        return companyRepository.getStudentsById(id);
    }
}
