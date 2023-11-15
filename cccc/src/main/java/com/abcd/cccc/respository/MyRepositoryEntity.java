package com.abcd.cccc.respository;

import com.abcd.cccc.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyRepositoryEntity extends JpaRepository<MyEntity, Long> {
    List<MyEntity> findAll();
}
