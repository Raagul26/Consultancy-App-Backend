package com.consulting.app.consultingappbackend.service;

import com.consulting.app.consultingappbackend.model.JobsApplied;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobsAppliedService {

    List<JobsApplied> getAllApplications();

    JobsApplied getCandidateStatus(String emailId);

    void applyJob(JobsApplied jobsApplied);

    void changeJobApplicationStatus(JobsApplied jobsApplied);

}
