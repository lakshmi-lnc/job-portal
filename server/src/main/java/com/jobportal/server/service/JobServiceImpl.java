package com.jobportal.server.service;

import com.jobportal.server.entity.*;
import com.jobportal.server.repository.JobApplicantsRepository;
import com.jobportal.server.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    private JobApplicantsRepository jobApplicantsRepository;

    public Job createJob(Job j) {
        return jobRepository.save(j);
    }

    public Job getJobById(Long id) {
        Optional<Job> j = jobRepository.findById(id);
        return j.get();
    }



    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getAllJobsByCompanyId(Long id) {
        return jobRepository.findAll();
    }
    public JobApplicants applyJob(Long userID, Long jobID){
        JobApplicants jobApplicants = new JobApplicants();
        jobApplicants.setJobId(jobID);
        jobApplicants.setUserId(userID);
       return jobApplicantsRepository.save(jobApplicants);
    }



    public List<Job> getAllJobsByCompany(Long companyId){
        return null;
    }
    public List<Job> getAllAppliedJobsByUser(Long userId){

        return jobRepository.getAllAppliedJobsByUser(userId);
    }

}
