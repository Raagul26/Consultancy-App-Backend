package com.consulting.app.consultingappbackend.service.impl;

import com.consulting.app.consultingappbackend.model.Admin;
import com.consulting.app.consultingappbackend.repository.AdminRepository;
import com.consulting.app.consultingappbackend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public boolean login(Admin admin) {
        Admin existingAdmin = adminRepository.findByEmailId(admin.getEmailId());
        if(existingAdmin!=null)
        {
            return Objects.equals(admin.getPassword(), existingAdmin.getPassword());
        }
        return false;
    }
}
