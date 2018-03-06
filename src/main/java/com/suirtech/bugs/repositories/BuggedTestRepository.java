package com.suirtech.bugs.repositories;

import com.suirtech.bugs.model.BuggedTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BuggedTestRepository extends CrudRepository<BuggedTest, Long> {

    List<BuggedTest> findAllByOrderByIdDesc();

//    BuggedTest findOne(Long id);


}
