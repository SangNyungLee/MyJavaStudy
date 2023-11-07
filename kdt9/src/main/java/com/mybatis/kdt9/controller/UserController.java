package com.mybatis.kdt9.controller;

import com.mybatis.kdt9.domain.User;
import com.mybatis.kdt9.dto.UserDTO;
import com.mybatis.kdt9.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    // 1. domain 만들기
    // 2. dto 만들기
    // 3. mapper 만들기
    // 4. service 만들기
    // 5. controller 만들기
    // -> UserService를 호출하고 그에 대한 결과를 받아와서 template으로 전달해주는 역할

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String getUser(Model model){
        List<UserDTO> users = userService.getUserList();
        model.addAttribute("list", users);
        return "user";
    }

    // get 방식으로 / user?name=이름&nickname=닉네임
    @GetMapping("/user")
    public String insertUser(@RequestParam String name, @RequestParam String nickname){
        userService.insertUser(name, nickname);
        return "user";
    }
}
