package com.crud.crudtest.service;

import com.crud.crudtest.Repository.PersonRepository;
import com.crud.crudtest.domain.Person;
import com.crud.crudtest.domain.PersonEntity;
import com.crud.crudtest.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
//    private PersonMapper personMapper;
    private PersonRepository personRepository;

    public void insertPerson(PersonDTO personDTO){
        Person person = new Person();

        person.setUser_id(personDTO.getUserId());
        person.setPassword(personDTO.getPassword());
        person.setName(personDTO.getName());

        personMapper.insertPerson(person);
    }

    //로그인
    public PersonDTO getPerson(PersonDTO personDTO) {
//        Person person = personMapper.getPerson(personDTO.getUser_id(), personDTO.getPassword());
        Optional<PersonEntity> person = personRepository.findByUseridAndPassword(personDTO.getUserId());
        PersonDTO data = new PersonDTO();
        data.setId(person.getId());

        return data;
    }

    //회원정보
    public PersonDTO getPersonData(long id){
        Optional<PersonEntity> person = PersonRepository.findById(id);

        PersonDTO data = new PersonDTO();
        data.setName(person.get().getName());
        data.setUser_id(person.get().getUser_id());
        data.setPassword(person.getPassword());
        System.out.println(person.getName()) ;
        return data;
    }
    //회원정보 수정
    public PersonDTO updatePerson(PersonDTO personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        person.setPassword(personDTO.getPassword());
        person.setUser_id(personDTO.getUserId());

        personMapper.updatePerson(person);
        return null;
    }
}
