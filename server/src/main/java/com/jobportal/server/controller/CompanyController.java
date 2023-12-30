package com.jobportal.server.controller;

import com.jobportal.server.entity.Company;
import com.jobportal.server.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/companies")
public class CompanyController {

    private CompanyService companyService;

    // build create Company REST API
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company savedCompany = companyService.createCompany(company);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }

    // build get company by id REST API
    // http://localhost:8080/api/companies/1
    @GetMapping("{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long companyId){
        Company company = companyService.getCompanyById(companyId);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    // Build Get All Companys REST API
    // http://localhost:8080/api/companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanys(){
        List<Company> companys = companyService.getAllCompanies();
        return new ResponseEntity<>(companys, HttpStatus.OK);
    }

    // Build Update Company REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/companies/1
    public ResponseEntity<Company> updateCompany(@PathVariable("id") Long companyId,
                                           @RequestBody Company company){
        company.setId(companyId);
        Company updatedCompany = companyService.updateCompany(company);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    // Build Delete Company REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") Long companyId){
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>("Company successfully deleted!", HttpStatus.OK);
    }
}