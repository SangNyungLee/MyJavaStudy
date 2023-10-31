package com.example.mySpring.controller;

import com.example.mySpring.dto.userInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("/practiceResponse")
    public userInfo myResponse(@RequestBody userInfo user){
        return user;
    }
}
