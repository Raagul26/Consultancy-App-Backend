package com.consulting.app.consultingappbackend.service.impl;

import com.consulting.app.consultingappbackend.model.Job;
import com.consulting.app.consultingappbackend.repository.JobRepository;
import com.consulting.app.consultingappbackend.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getActiveJobs() {
        return jobRepository.findByStatus("active");
    }

    @Override
    public Job createJob(Job job) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        int jobId = jobRepository.findAll().size() + 1;
        Job newJob = new Job();
        newJob.setJobId("JOB-"+jobId);
        newJob.setTitle(job.getTitle());
        newJob.setOverview(job.getOverview());
        newJob.setQualifications(job.getQualifications());
        newJob.setLocation(job.getLocation());
        newJob.setSkills(job.getSkills());
        newJob.setResponsibilities(job.getResponsibilities());
        newJob.setStatus("active");
        newJob.setCreatedOn(dateFormat.format(date));

        return jobRepository.insert(newJob);
    }

    @Override
    public void deleteJob(String jobId) {
        Job existingJob = jobRepository.findByJobId(jobId);
        existingJob.setStatus("deleted");
        jobRepository.save(existingJob);
    }

    @Override
    public void updateJob(Job job) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Job existingJob = jobRepository.findByJobId(job.getJobId());
        existingJob.setTitle(job.getTitle());
        existingJob.setOverview(job.getOverview());
        existingJob.setQualifications(job.getQualifications());
        existingJob.setLocation(job.getLocation());
        existingJob.setSkills(job.getSkills());
        existingJob.setResponsibilities(job.getResponsibilities());
        existingJob.setLastUpdatedOn(dateFormat.format(date));

        jobRepository.save(existingJob);
    }
}
