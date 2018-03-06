package com.suirtech.bugs.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class HomeController {

//    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    public HomeController() {
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        return "Welcome to the app";
    }


}
