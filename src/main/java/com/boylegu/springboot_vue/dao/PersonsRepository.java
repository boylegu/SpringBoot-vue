package com.boylegu.springboot_vue.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boylegu.springboot_vue.entities.Persons;


public interface PersonsRepository extends JpaRepository<Persons, Long> {
}
