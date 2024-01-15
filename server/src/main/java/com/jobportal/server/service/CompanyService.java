package com.jobportal.server.service;

import com.jobportal.server.entity.Company;
import com.jobportal.server.entity.User;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company c);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company authenticate(String email, String password);


    Company updateCompany(Company c);

    void deleteCompany(Long id);
}
