package com.consulting.app.consultingappbackend.service;

import com.consulting.app.consultingappbackend.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {

    List<Job> getAllJobs();

    List<Job> getActiveJobs();

    Job createJob(Job job);

    void deleteJob(String jobId);

    void updateJob(Job job);
}
