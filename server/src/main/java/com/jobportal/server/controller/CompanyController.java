package com.jobportal.server.controller;

import com.jobportal.server.entity.Company;
import com.jobportal.server.entity.Job;
import com.jobportal.server.entity.User;
import com.jobportal.server.service.CompanyService;
import com.jobportal.server.service.JobService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/companies")
public class CompanyController {

    private CompanyService companyService;
    private JobService jobService;
    // build create Company REST API

    @GetMapping("company-login")
    public String companyLogin(@ModelAttribute("formModel") Company formModel) {
        return "company-login";
    }

    @GetMapping("add-job")
    public String showJobForm(@ModelAttribute("formModel") Job formModel) {
        return "add-job";
    }
     @GetMapping("list-job")
    public String listJobs(Model model) {
        model.addAttribute("jobs", this.jobService.getAllJobs());
        return "list-job";
    }

    @PostMapping("post-job")
    public String addJob(@Valid Job job, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-job";
        }
        this.jobService.createJob(job);
        return "redirect:list-job";
    }

    @GetMapping("add-company")
    public String showCompanyForm(@ModelAttribute("formModel") Company formModel) {
        return "add-company";
    }
    @GetMapping("list")
    public String listCompanies(Model model) {
        model.addAttribute("companies", this.companyService.getAllCompanies());
        return "list-company";
    }

    @PostMapping("add")
    public String addCompany(@Valid Company company, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-company";
        }
        this.companyService.createCompany(company);
        return "redirect:list";
    }

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

    @PostMapping("{id}/job")
    public ResponseEntity<Job> postAJob(@PathVariable("id") Long companyId, @RequestBody Job job){
        Company company = companyService.getCompanyById(companyId);
        //List<Job> jobs = new ArrayList<Job>();
        job.setCompany(company);
        //jobs.add(job);
        Job j = jobService.createJob(job);
      //  Company savedCompany = companyService.createCompany(company);
        return new ResponseEntity<>(j, HttpStatus.CREATED);
    }

    @GetMapping("/job/all")
    public ResponseEntity<List<Job>> getAllJobs(){
        List<Job> jobs = jobService.getAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}