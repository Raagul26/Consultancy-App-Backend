package com.consulting.app.consultingappbackend.repository;

import com.consulting.app.consultingappbackend.model.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate,String> {

    Candidate findByEmailIdAndStatus(String emailId,String status);

}
