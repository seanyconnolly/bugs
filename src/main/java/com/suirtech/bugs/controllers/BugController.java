package com.suirtech.bugs.controllers;

import com.suirtech.bugs.model.Bug;
import com.suirtech.bugs.service.BugService;
import com.suirtech.bugs.service.BugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.soap.SOAPPart;


@RestController
@RequestMapping("/bugs")
public class BugController {

    private static final Logger logger = LoggerFactory.getLogger(BugController.class);

    private BugService bugService;

    @Autowired
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping( value = "/", method = RequestMethod.POST )
    public Bug create(@RequestBody Bug bug){
        return bugService.create(bug);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Bug> listBugs() {
        logger.info("WILL GET ALL BUGS");
        return bugService.list();
    }

    @RequestMapping(value = "/issue/{issue}", method = RequestMethod.GET)
    public Bug view(@PathVariable(value = "issue") String issue) {
        return bugService.getByIssue(issue);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Bug view(@PathVariable(value = "id") Long id) {
        return bugService.getById(id);
    }

//
//    @RequestMapping(value = "/byIssue/{issue}}", method = RequestMethod.GET)
//    public Iterable<Bug> view(@PathVariable(value = "issue") String issue) {
//        return bugService.getByIssue(id);
//    }

}
