package com.jobportal.server.service;

import com.jobportal.server.entity.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(Company c);

    Company getCompanyById(Long id);

    List<Company> getAllCompanies();

    Company updateCompany(Company c);

    void deleteCompany(Long id);
}
