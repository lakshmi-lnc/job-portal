package com.jobportal.server.repository;

import com.jobportal.server.entity.Job;
import com.jobportal.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Long> {

    //select * from job j where j.id in (select job_id from `job-applicants` ja where user_id=1)
    @Query(
            nativeQuery = true,
            value = "select * from job j where j.id in (select job_id from `job-applicants` ja where user_id=:userId)")
    List<Job> getAllAppliedJobsByUser(@Param("userId") Long userId);
}
