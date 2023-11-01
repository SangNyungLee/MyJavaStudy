package com.example.jdbc.jdbcExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandRun implements CommandLineRunner {

    @Autowired
    private UserJdbcRepository user;

    @Override
    public void run(String... args) throws Exception {
        user.insert(new Users(1,"gildong","seoul"));
        user.insert(new Users(2,"baedal","daejeon"));
        user.insert(new Users(3,"jongsu","busan"));
        System.out.println(user.findId(3));

    }
}
