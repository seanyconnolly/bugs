package com.suirtech.bugs.controllers;

import com.suirtech.bugs.model.Bug;
import com.suirtech.bugs.model.BuggedTest;
import com.suirtech.bugs.service.BugService;
import com.suirtech.bugs.service.BuggedTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/buggedTests")
public class BuggedTestController {

    private static final Logger logger = LoggerFactory.getLogger(BuggedTestController.class);

    private BuggedTestService buggedTestService;


    @Autowired
    public BuggedTestController(BuggedTestService buggedTestService) {
        this.buggedTestService = buggedTestService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<BuggedTest> listBuggedTests() {
        return buggedTestService.list();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<BuggedTest> view(@PathVariable(value = "id") Long id) {
        return buggedTestService.getById(id);
    }

}
