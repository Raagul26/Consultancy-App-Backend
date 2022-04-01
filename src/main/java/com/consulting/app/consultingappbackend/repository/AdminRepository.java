package com.consulting.app.consultingappbackend.repository;

import com.consulting.app.consultingappbackend.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin,Integer> {

    Admin findByEmailId(String emailId);

}
