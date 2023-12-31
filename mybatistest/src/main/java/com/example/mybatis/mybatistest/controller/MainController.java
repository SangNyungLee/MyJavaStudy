package com.example.mybatis.mybatistest.controller;

import com.example.mybatis.mybatistest.domain.Users;
import com.example.mybatis.mybatistest.dto.UserDTO;
import com.example.mybatis.mybatistest.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model){
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>)mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @GetMapping("/user/insert")
    public String getInsertUser(@RequestParam String name, @RequestParam String address, Model model){
        Users users = new Users();
        users.setName(name);
        users.setAddress(address);
        mainService.addUser(users);

        model.addAttribute("list", null);
        return "user";
    }
}
