package com.example.mybatis.mybtistest.mapper;

import com.example.mybatis.mybtistest.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainMapper {

    //mapper 참고하기
    List<Users> findAll();

    //mapper xml 참고 안하기
    @Insert("INSERT INTO users (name, password) VALUES (#{name}, #{password})")
    void insertUser(Users user);

    @Select("SELECT * FROM users WHERE name = #{name} AND password = #{password}")
    Users findUser(Users user);

}
