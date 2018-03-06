package com.suirtech.bugs.service;

import com.suirtech.bugs.model.Bug;
import com.suirtech.bugs.repositories.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {


    private BugRepository bugRepository;

    @Autowired
    public BugServiceImpl(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public Bug getLatestBug() {
        return bugRepository.findFirstByOrderByIdDesc();
    }

    public List<Bug> list() {
        return bugRepository.findAllByOrderByIdDesc();
    }

    public Bug getById(Long id) {
        return bugRepository.findById(id).get();
    }

    public Bug getByIssue(String issue) {
        return bugRepository.findByIssue(issue);
    }

    @Transactional
    public Bug create(Bug bug) {
        return bugRepository.save(bug);
    }

    @Override
    public Bug read(long id) {
        return bugRepository.findById(id).get();
    }

    @Override
    public Bug update(long id, Bug update) {
        Bug bug = bugRepository.findById(id).get();
        return bugRepository.save(bug);
    }

    @Override
    public void delete(long id) {
        Bug bug = bugRepository.findById(id).get();
        bugRepository.delete(bug);
    }

}


