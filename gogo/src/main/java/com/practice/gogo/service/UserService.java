package com.practice.gogo.service;

import com.practice.gogo.domain.UserEntity;
import com.practice.gogo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    @Autowired
    UserRepository userRepository;

}
