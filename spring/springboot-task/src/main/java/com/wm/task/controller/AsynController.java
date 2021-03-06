package com.wm.task.controller;

import com.wm.task.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsynController {

    @Autowired
    AsynService asynService;

    @GetMapping("/hello")
    public String hello(){
        asynService.hello();
        return "success";
    }
}
