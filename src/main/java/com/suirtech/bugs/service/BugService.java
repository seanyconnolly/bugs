package com.suirtech.bugs.service;

import com.suirtech.bugs.model.Bug;

import java.util.List;
import java.util.Optional;

public interface BugService {

    List<Bug> list();

    Bug getById(Long id);

    Bug getByIssue(String issue);

    Bug create(Bug bug);

    Bug read(long id);

    Bug update(long id, Bug bug);

    void delete(long id);

}


