package com.jobportal.server.service;

import com.jobportal.server.entity.Company;
import com.jobportal.server.entity.Job;
import com.jobportal.server.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

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
}
