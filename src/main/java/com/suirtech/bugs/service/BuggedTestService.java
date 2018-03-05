package com.suirtech.bugs.service;

import com.suirtech.bugs.model.BuggedTest;
import com.suirtech.bugs.repositories.BuggedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuggedTestService {


    private BuggedTestRepository buggedTestRepository;

    @Autowired
    public BuggedTestService(BuggedTestRepository buggedTestRepository){
        this.buggedTestRepository = buggedTestRepository;
    }

    public List<BuggedTest> list() {
        return buggedTestRepository.findAllByOrderByIdDesc();
    }

    public Optional<BuggedTest> getById(Long id) {
        return buggedTestRepository.findById(id);
    }

}


