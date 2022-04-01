package com.consulting.app.consultingappbackend.repository;

import com.consulting.app.consultingappbackend.model.JobsApplied;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsAppliedRepository extends MongoRepository<JobsApplied,String> {

    JobsApplied findByEmailId(String emailId);

    JobsApplied findByJobIdAndEmailId(String jobId, String emailId);
}
