package com.consulting.app.consultingappbackend.controller;

import com.consulting.app.consultingappbackend.controller.response.ApiResponse;
import com.consulting.app.consultingappbackend.model.Job;
import com.consulting.app.consultingappbackend.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobServiceImpl jobServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll()
    {
        ApiResponse response = new ApiResponse();
        response.setStatus("Success");
        response.setMessage("Fetched successfully");
        response.setData(jobServiceImpl.getAllJobs());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/active")
    public ResponseEntity<ApiResponse> getActiveJobs()
    {
        ApiResponse response = new ApiResponse();
        response.setStatus("Success");
        response.setMessage("Fetched available jobs successfully");
        response.setData(jobServiceImpl.getActiveJobs());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createJob(@Valid @RequestBody Job job)
    {
        ApiResponse response = new ApiResponse();
        response.setData(jobServiceImpl.createJob(job));
        response.setStatus("Success");
        response.setMessage("Job created successfully");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{jobId}")
    public ResponseEntity<ApiResponse> deleteJob(@NotBlank @PathVariable String jobId)
    {
        ApiResponse response = new ApiResponse();
        jobServiceImpl.deleteJob(jobId);
        response.setStatus("Success");
        response.setMessage("Job deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateJob(@Valid @RequestBody Job job)
    {
        ApiResponse response = new ApiResponse();
        jobServiceImpl.updateJob(job);
        response.setStatus("Success");
        response.setMessage("Job updated successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
