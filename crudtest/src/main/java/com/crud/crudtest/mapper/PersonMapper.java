package com.crud.crudtest.mapper;

import com.crud.crudtest.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PersonMapper {
    @Insert("INSERT into person (user_id, password, name) VALUES (#{user_id}, #{password}, #{name})")
    void insertPerson(Person person);

    @Select("SELECT * FROM person WHERE (user_id = #{user_id} and password=#{password})")
    Person getPerson(String user_id, String password);
}
