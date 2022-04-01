package com.consulting.app.consultingappbackend.service;

import com.consulting.app.consultingappbackend.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    boolean login(Admin admin);

}
