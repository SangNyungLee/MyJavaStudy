package com.abcd.cccc.controller;

import com.abcd.cccc.MyEntity;
import com.abcd.cccc.respository.MyRepositoryEntity;
import com.abcd.cccc.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class MyEntityController {

    @Autowired
    private MyService myService;

    @GetMapping("/entities")
    public List<MyEntity> getEntitiesByColumnName(@RequestParam String columnName){
        System.out.println("?!!!!!");
        System.out.println(myService.getEntitiesByColumnName(columnName));
        return myService.getEntitiesByColumnName(columnName);
    }
}
