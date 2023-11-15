package com.abcd.cccc.service;

import com.abcd.cccc.MyEntity;
import com.abcd.cccc.respository.MyRepositoryEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyService {

    @Autowired
    private MyRepositoryEntity myRepositoryEntity;

    public List<MyEntity> getEntitiesByColumnName(String columnName){
        System.out.println("?!?!?!?!?!" + myRepositoryEntity.findAll());
        return null;
    }
}
