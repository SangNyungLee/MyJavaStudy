package com.example.mybatis.mybatistest.mapper;

import com.example.mybatis.mybatistest.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    //mapper 참고하기
    List<Users> retrieveAll();

    //mapper xml 참고 안하기
    @Insert("INSERT INTO USER (NAME, ADDRESS) VALUES (#{name}, #{address})")
    void insertUser(Users users);
}
