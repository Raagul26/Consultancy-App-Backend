package com.consulting.app.consultingappbackend.service;

import com.consulting.app.consultingappbackend.model.Candidate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CandidateService {

    List<Candidate> getAllCandidates();

    Boolean login(String emailId);

    void createCandidate(Candidate candidate);

    void deleteCandidate(String emailId);

    void updateCandidate(Candidate candidate);

}
