package com.boylegu.springboot_vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.boylegu.springboot_vue.entities.Persons;

import java.util.List;


public interface PersonsRepository extends JpaRepository<Persons, Long> {

    public static final String FIND_SEX = "select DISTINCT sex from Persons p";

    @Query(FIND_SEX)
    List<Persons> findSex();
}
