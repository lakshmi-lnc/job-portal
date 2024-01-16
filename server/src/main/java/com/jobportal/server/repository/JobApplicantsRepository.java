package com.jobportal.server.repository;

import com.jobportal.server.entity.JobApplicants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicantsRepository extends JpaRepository<JobApplicants, Long> {

}
