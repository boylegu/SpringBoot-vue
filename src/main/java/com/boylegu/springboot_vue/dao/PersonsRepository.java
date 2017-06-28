package com.boylegu.springboot_vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.boylegu.springboot_vue.entities.Persons;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface PersonsRepository extends JpaRepository<Persons, Long> {

    public static final String FIND_SEX = "select DISTINCT sex from Persons p";

    @Query(FIND_SEX)
    List<Persons> findSex();

    Page<Persons> findAll(Pageable pageable);

    Page<Persons> findBySexAndEmailContains(String sexName, String emailName, Pageable pageable);

    Page<Persons> findBySex(String sexName, Pageable pageable);

}
