package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hi")
    public String getHi(Model model){
        model.addAttribute("msg", "hi");
        return "hi";
    }
}
