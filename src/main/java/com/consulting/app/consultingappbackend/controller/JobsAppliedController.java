package com.consulting.app.consultingappbackend.controller;

import com.consulting.app.consultingappbackend.controller.response.ApiResponse;
import com.consulting.app.consultingappbackend.model.JobsApplied;
import com.consulting.app.consultingappbackend.service.impl.JobsAppliedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@RestController
@RequestMapping("/api/applications")
public class JobsAppliedController {

    @Autowired
    private JobsAppliedServiceImpl jobsAppliedServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll()
    {
        ApiResponse response = new ApiResponse();
        response.setStatus("Success");
        response.setMessage("Fetched Successfully");
        response.setData(jobsAppliedServiceImpl.getAllApplications());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{emailId}")
    public JobsApplied getStatus(@PathVariable @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "must be a valid email id") String emailId)
    {
        return jobsAppliedServiceImpl.getCandidateStatus(emailId);
    }

    @PostMapping("/apply")
    public ResponseEntity<ApiResponse> createApplication(@Valid @RequestBody JobsApplied jobsApplied)
    {
        ApiResponse response = new ApiResponse();
        jobsAppliedServiceImpl.applyJob(jobsApplied);
        response.setStatus("Success");
        response.setMessage("Application created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/changeStatus")
    public ResponseEntity<ApiResponse> changeStatus(@Valid @RequestBody JobsApplied jobsApplied)
    {
        ApiResponse response = new ApiResponse();
        jobsAppliedServiceImpl.changeJobApplicationStatus(jobsApplied);
        response.setStatus("Success");
        response.setMessage("Application status updated");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
