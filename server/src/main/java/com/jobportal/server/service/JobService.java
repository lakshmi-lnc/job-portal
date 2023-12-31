package com.jobportal.server.service;

import com.jobportal.server.entity.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job j);
    Job getJobById(Long id);

    List<Job> getAllJobs();

    void deleteJob(Long id);

    List<Job> getAllJobsByCompanyId(Long id);
}
