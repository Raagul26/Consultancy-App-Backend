package com.consulting.app.consultingappbackend.service.impl;

import com.consulting.app.consultingappbackend.model.Candidate;
import com.consulting.app.consultingappbackend.repository.CandidateRepository;
import com.consulting.app.consultingappbackend.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Boolean login(String emailId) {
        return candidateRepository.findByEmailIdAndStatus(emailId, "active") != null;
    }

    @Override
    public void createCandidate(Candidate candidate) {
        Candidate newCandidate = new Candidate();
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newCandidate.setName(candidate.getName());
        newCandidate.setEmailId(candidate.getEmailId());
        newCandidate.setPhoneNo(candidate.getPhoneNo());
        newCandidate.setSkills(candidate.getSkills());
        newCandidate.setQualification(candidate.getQualification());
        newCandidate.setExperience(candidate.getExperience());
        newCandidate.setStatus("active");
        newCandidate.setCreatedOn(dateFormat.format(date));

        candidateRepository.insert(newCandidate);
    }

    @Override
    public void updateCandidate(Candidate candidate) {
        Candidate existingCandidate = candidateRepository.findByEmailIdAndStatus(candidate.getEmailId(),"active");
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        existingCandidate.setName(candidate.getName());
        existingCandidate.setEmailId(candidate.getEmailId());
        existingCandidate.setPhoneNo(candidate.getPhoneNo());
        existingCandidate.setSkills(candidate.getSkills());
        existingCandidate.setQualification(candidate.getQualification());
        existingCandidate.setExperience(candidate.getExperience());
        existingCandidate.setLastUpdatedOn(dateFormat.format(date));

        candidateRepository.save(existingCandidate);
    }

    @Override
    public void deleteCandidate(String emailId) {
        Candidate existingCandidate = candidateRepository.findByEmailIdAndStatus(emailId,"active");
        existingCandidate.setStatus("deleted");
        candidateRepository.save(existingCandidate);
    }
}
