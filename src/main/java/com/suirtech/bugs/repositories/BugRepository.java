package com.suirtech.bugs.repositories;

import com.suirtech.bugs.model.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {

    Bug findFirstByOrderByIdDesc();

    List<Bug> findAllByOrderByIdDesc();

    Bug findByIssue(String issue);

//    Bug findOne(Long id);
}
