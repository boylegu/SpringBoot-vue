package com.boylegu.springboot_vue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.boylegu.springboot_vue.dao.PersonsRepository;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/persons")
public class MainController {

    /**
     * @api {GET} /api/persons/sex Get all sexList
     * @apiName GetAllSexList
     * @apiGroup Info Manage
     * @apiVersion 1.0.0
     * @apiExample {httpie} Example usage:
     * <p>
     * http /api/persons/sex
     * @apiSuccess {String} label
     * @apiSuccess {String} value
     */

    @Autowired
    private PersonsRepository personsRepository;

    @RequestMapping(value = "/sex", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {

        ArrayList<Map<String, String>> results = new ArrayList<Map<java.lang.String, java.lang.String>>();

        for (Object value : personsRepository.findSex()) {
            Map<String, String> sex = new HashMap<String, String>();

            sex.put("label", value.toString());
            sex.put("value", value.toString());
            results.add(sex);
        }
        ResponseEntity<ArrayList<Map<String, String>>> responseEntity = new ResponseEntity<>(results,
                HttpStatus.OK);
        return responseEntity;
    }

}