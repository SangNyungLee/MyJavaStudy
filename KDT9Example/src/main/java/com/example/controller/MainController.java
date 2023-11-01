package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(){
        return "request";
    }

    @GetMapping("/get/response1")
    // ?key=value
    // /get/response1?name=abc
    // 기본값으로 required = true를 갖기 떄문에 ?name= 을 필수로 보내줘야 한다.
    public String getResponse1(@RequestParam(value = "name") String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }

    @GetMapping("/get/response2")
    public String getResponse2(@RequestParam(value = "name", required = false) String n, Model model){
        model.addAttribute("name", n);
        return "response";
    }

    @GetMapping("/get/response3/{name}")
    public String getResponse3(@PathVariable String name, @PathVariable("age") String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }

    @GetMapping({"/get/response4/{name}, /get/response4/{name}/{age}"})
    public String getResponse4(@PathVariable String name, @PathVariable String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age",age);
        return "response";
    }

}
