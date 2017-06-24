package com.boylegu.springboot_vue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boylegu.springboot_vue.dao.PersonsRepository;
import com.boylegu.springboot_vue.entities.Persons;


import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class MainController {

    @Autowired
    private PersonsRepository personsRepository;

    @RequestMapping(value="/sex", method = RequestMethod.GET)
    public List<Persons> getAll() {

        return personsRepository.findAll();
    }
}