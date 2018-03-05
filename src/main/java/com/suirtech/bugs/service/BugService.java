package com.suirtech.bugs.service;

import com.suirtech.bugs.model.Bug;
import com.suirtech.bugs.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugService {


    private BugRepository bugRepository;

    @Autowired
    public BugService(BugRepository bugRepository){
        this.bugRepository = bugRepository;
    }

    public Bug getLatestBug(){
        return bugRepository.findFirstByOrderByIdDesc();
    }

    public List<Bug> list() {
        return bugRepository.findAllByOrderByIdDesc();
    }

    public Optional<Bug> getById(Long id) {
        return bugRepository.findById(id);
    }

    public Bug getByIssue(String issue) {
        return bugRepository.findByIssue(issue);
    }


}


