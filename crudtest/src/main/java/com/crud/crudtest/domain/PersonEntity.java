package com.crud.crudtest.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gimozizi")
public class PersonEntity {

    @Id
    private long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255, nullable = false)
    private String user_id;

    private String email;

    //기본생성자
    public PersonEntity(){}
}
