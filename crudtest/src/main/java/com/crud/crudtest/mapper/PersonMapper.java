package com.crud.crudtest.mapper;

import com.crud.crudtest.domain.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PersonMapper {
    @Insert("INSERT into person (user_id, password, name) VALUES (#{user_id}, #{password}, #{name})")
    void insertPerson(Person person);

    @Select("SELECT * FROM person WHERE (user_id = #{user_id} and password=#{password}) ORDER By id DESC LIMIT 1")
    Person getPerson(String user_id, String password);

    //사용자 정보 조회
    @Select("SELECT * FROM person WHERE id=#{id}")
    Person getPersonData(long id);

    //사용자 정보 수정
    @Update("UPDATE person SET password=#{password}, name=#{name} WHERE user_id=#{user_id}")
    void updatePerson(Person person);

    //회
}
