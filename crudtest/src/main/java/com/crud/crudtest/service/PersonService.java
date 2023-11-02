package com.crud.crudtest.service;

import com.crud.crudtest.domain.Person;
import com.crud.crudtest.dto.PersonDTO;
import com.crud.crudtest.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public void insertPerson(PersonDTO personDTO){
        Person person = new Person();

        person.setUser_id(personDTO.getUser_id());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());

        personMapper.insertPerson(person);
    }

    //로그인
    public PersonDTO getPerson(PersonDTO personDTO){
        Person person = personMapper.getPerson(personDTO.getUser_id(), personDTO.getPassword());
        if(person == null) {
            return null;
        }
        PersonDTO perDto = new PersonDTO();
        perDto.setUser_id(personDTO.getUser_id());
        perDto.setPassword(person.getPassword());

        return perDto;
    }
}
