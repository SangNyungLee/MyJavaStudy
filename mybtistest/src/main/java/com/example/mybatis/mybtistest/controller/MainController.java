package com.example.mybatis.mybtistest.controller;

import com.example.mybatis.mybtistest.domain.Users;
import com.example.mybatis.mybtistest.dto.UserDTO;
import com.example.mybatis.mybtistest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/")
    public String mainPage(){
        return "user";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<UserDTO> userList = mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String password, Model model) {
        Users user = new Users();
        user.setName(name);
        user.setPassword(password);
        mainService.addUser(user);

        model.addAttribute("list", null);
        return "user";
    }
    @GetMapping("/find")
    public String findMyUser(@RequestParam String name, @RequestParam String password,  Model model){
        Users user = new Users();
        user.setName(name);
        user.setPassword(password);
        mainService.selectUser(user);
        model.addAttribute("findName", name);
        model.addAttribute("findPassword", password);
        model.addAttribute("good", "good");
        return "user";
    }
}
