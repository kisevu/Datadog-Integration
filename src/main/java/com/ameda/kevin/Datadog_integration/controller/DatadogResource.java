package com.ameda.kevin.Datadog_integration.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: kev.Ameda
 */
@RestController
public class DatadogResource {

    @GetMapping("/name")
    public String getName(){
        return "Kevin Ameda Kisevu";
    }

    @GetMapping("/slow")
    public String slowly() throws InterruptedException{
        Thread.sleep(3000);
        return "slow endpoint";
    }
}
