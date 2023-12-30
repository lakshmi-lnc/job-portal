package com.jobportal.server.service;

import com.jobportal.server.entity.Company;
import com.jobportal.server.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService{
    private CompanyRepository companyRepository;

    
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    
    public Company getCompanyById(Long companyId) {
        Optional<Company> optionalCompany = companyRepository.findById(companyId);
        return optionalCompany.get();
    }

    
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    
    public Company updateCompany(Company company) {
        Company existingCompany = companyRepository.findById(company.getId()).get();
      /*  existingCompany.setFirstName(company.getFirstName());
        existingCompany.setLastName(company.getLastName());
        existingCompany.setEmail(company.getEmail());*/
        Company updatedCompany = companyRepository.save(existingCompany);
        return updatedCompany;
    }

    
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
