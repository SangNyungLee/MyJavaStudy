package com.example.mySpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewController {

    @GetMapping("/go")
    public String testMainController(){
        return "ppp";
    }
    @GetMapping("/prr")
    @ResponseBody
    public String testMyController(@RequestParam String name, @RequestParam String age, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "ppp";
    }


}
