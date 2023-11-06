package com.example.mybatis.mybatistest.service;

import com.example.mybatis.mybatistest.domain.Users;
import com.example.mybatis.mybatistest.dto.UserDTO;
import com.example.mybatis.mybatistest.mapper.MainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    //XML 주입 - SQL 쿼리와 Java객체 간의 정의
    @Autowired
    private MainMapper mainMapper;

    public List<UserDTO> getUserList(){
        List<Users> result = mainMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<>();

        for(int i=0; i< result.size() ; i++){
            UserDTO user = new UserDTO();

            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setAddress(result.get(i).getAddress());
            users.add(user);
        }
        return users;
    }

    public void addUser(Users users){
        mainMapper.insertUser(users);
    }
}