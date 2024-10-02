package com.example.testproject.controller;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


// 컨트롤러
@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    //고전적인 방식
    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @RequestMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("log-test")
    public void LogTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");

    }
}
