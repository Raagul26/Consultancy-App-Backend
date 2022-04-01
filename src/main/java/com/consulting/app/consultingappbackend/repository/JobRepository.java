package com.consulting.app.consultingappbackend.repository;

import com.consulting.app.consultingappbackend.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job,String> {

    Job findByJobId(String jobId);

    List<Job> findByStatus(String status);

}
