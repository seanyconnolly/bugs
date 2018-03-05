package com.suirtech.bugs.controllers;

import com.suirtech.bugs.model.Bug;
import com.suirtech.bugs.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/bugs")
public class BugController {

    private static final Logger logger = LoggerFactory.getLogger(BugController.class);

    private BugService bugService;


    @Autowired
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Bug> listBugs() {
        return bugService.list();
    }

    @RequestMapping(value = "/issue/{issue}", method = RequestMethod.GET)
    public Bug view(@PathVariable(value = "issue") String issue) {
        return bugService.getByIssue(issue);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Bug> view(@PathVariable(value = "id") Long id) {
        return bugService.getById(id);
    }

//
//    @RequestMapping(value = "/byIssue/{issue}}", method = RequestMethod.GET)
//    public Iterable<Bug> view(@PathVariable(value = "issue") String issue) {
//        return bugService.getByIssue(id);
//    }

}
