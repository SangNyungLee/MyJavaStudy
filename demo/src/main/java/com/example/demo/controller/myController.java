package com.example.demo.controller;

import com.example.demo.GoodApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class myController {
    @GetMapping("/api/demo-web")
    public List<String> Hello(){
        return Arrays.asList("리액트 스프링", "연결 성공");
    }
}
