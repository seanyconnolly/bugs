package com.suirtech.bugs.service;

import com.suirtech.bugs.model.BuggedTest;
import com.suirtech.bugs.repositories.BuggedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuggedTestServiceImpl implements BuggedTestService {

    private BuggedTestRepository buggedTestRepository;

    @Autowired
    public BuggedTestServiceImpl(BuggedTestRepository buggedTestRepository) {
        this.buggedTestRepository = buggedTestRepository;
    }

    public List<BuggedTest> list() {
        return buggedTestRepository.findAllByOrderByIdDesc();
    }

    public BuggedTest getById(Long id) {
        return buggedTestRepository.findById(id).get();
    }

}


