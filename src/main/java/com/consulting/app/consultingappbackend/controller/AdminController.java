package com.consulting.app.consultingappbackend.controller;

import com.consulting.app.consultingappbackend.controller.response.ApiResponse;
import com.consulting.app.consultingappbackend.model.Admin;
import com.consulting.app.consultingappbackend.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid Admin admin)
    {
        ApiResponse response = new ApiResponse();
        if(adminServiceImpl.login(admin))
        {
            response.setStatus("Success");
            response.setMessage("Admin Logged In Successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            response.setStatus("Failed");
            response.setMessage("Login Failed!");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

}
