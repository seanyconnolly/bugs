package com.suirtech.bugs.repositories;

import com.suirtech.bugs.model.Bug;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BugRepository extends CrudRepository<Bug, Long>{

    Bug findFirstByOrderByIdDesc();

    List<Bug> findAllByOrderByIdDesc();

    Bug findByIssue(String issue);

}
