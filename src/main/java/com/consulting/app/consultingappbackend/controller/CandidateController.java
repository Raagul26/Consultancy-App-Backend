package com.consulting.app.consultingappbackend.controller;

import com.consulting.app.consultingappbackend.controller.response.ApiResponse;
import com.consulting.app.consultingappbackend.model.Candidate;
import com.consulting.app.consultingappbackend.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.Map;

@RestController
@RequestMapping("/api/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll()
    {
        ApiResponse response = new ApiResponse();
        response.setStatus("Success");
        response.setMessage("Fetched Successfully");
        response.setData(candidateServiceImpl.getAllCandidates());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody Map<String,String> credentials)
    {
        ApiResponse response = new ApiResponse();
        if(candidateServiceImpl.login(credentials.get("emailId")))
        {
            response.setStatus("Success");
            response.setMessage("LoggedIn Successfully");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else{
        response.setStatus("Failed");
        response.setMessage("Invalid Email Id");
        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }

    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCandidate(@Valid @RequestBody Candidate candidate)
    {
        ApiResponse response = new ApiResponse();
        candidateServiceImpl.createCandidate(candidate);
        response.setStatus("Success");
        response.setMessage("Candidate created successfully!");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateCandidate(@Valid @RequestBody Candidate candidate)
    {
        ApiResponse response = new ApiResponse();
        candidateServiceImpl.updateCandidate(candidate);
        response.setStatus("Success");
        response.setMessage("Candidate updated successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{emailId}")
    public ResponseEntity<ApiResponse> deleteCandidate(@PathVariable @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "must be a valid email id") String emailId)
    {
        ApiResponse response =new ApiResponse();
        candidateServiceImpl.deleteCandidate(emailId);
        response.setStatus("Success");
        response.setMessage("Candidate deleted successfully");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
