package com.consulting.app.consultingappbackend.service.impl;

import com.consulting.app.consultingappbackend.model.JobsApplied;
import com.consulting.app.consultingappbackend.repository.JobsAppliedRepository;
import com.consulting.app.consultingappbackend.service.JobsAppliedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobsAppliedServiceImpl implements JobsAppliedService {

    @Autowired
    private JobsAppliedRepository jobsAppliedRepository;

    @Override
    public List<JobsApplied> getAllApplications() {
        return jobsAppliedRepository.findAll();
    }

    @Override
    public JobsApplied getCandidateStatus(String emailId) {
        return jobsAppliedRepository.findByEmailId(emailId);
    }

    @Override
    public void applyJob(JobsApplied jobsApplied) {
        JobsApplied newApplication = new JobsApplied();
        newApplication.setJobId(jobsApplied.getJobId());
        newApplication.setEmailId(jobsApplied.getEmailId());
        newApplication.setStatus("Applied");

        jobsAppliedRepository.insert(newApplication);
    }

    @Override
    public void changeJobApplicationStatus(JobsApplied jobsApplied) {
        JobsApplied existingApplication = jobsAppliedRepository.findByJobIdAndEmailId(jobsApplied.getJobId(), jobsApplied.getEmailId());
        existingApplication.setStatus(jobsApplied.getStatus());
        jobsAppliedRepository.save(existingApplication);
    }

}
