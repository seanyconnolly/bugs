package com.suirtech.bugs.service;

import com.suirtech.bugs.model.BuggedTest;
import com.suirtech.bugs.repositories.BuggedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BuggedTestService {


    List<BuggedTest> list();

    BuggedTest getById(Long id);

}


