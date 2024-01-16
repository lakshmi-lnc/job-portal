package com.jobportal.server.service;

import com.jobportal.server.entity.*;

import java.util.List;

public interface JobService {
    Job createJob(Job j);
    Job getJobById(Long id);

    JobApplicants applyJob(Long userID, Long jobID);


    List<Job> getAllJobsByCompany(Long companyId);
    List<Job> getAllAppliedJobsByUser(Long userId);

    List<Job> getAllJobs();

    void deleteJob(Long id);

    List<Job> getAllJobsByCompanyId(Long id);
}
