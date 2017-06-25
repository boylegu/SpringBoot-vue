package com.boylegu.springboot_vue.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;

import com.boylegu.springboot_vue.controller.pagination.PaginationMultiTypeValuesHelper;
import com.boylegu.springboot_vue.dao.PersonsRepository;

import java.util.*;


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
    public ResponseEntity<?> getSexAll() {

        ArrayList<Map<String, String>> results = new ArrayList<>();

        for (Object value : personsRepository.findSex()) {
            Map<String, String> sex = new HashMap<>();

            sex.put("label", value.toString());
            sex.put("value", value.toString());
            results.add(sex);
        }
        ResponseEntity<ArrayList<Map<String, String>>> responseEntity = new ResponseEntity<>(results,
                HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Map<String, PaginationMultiTypeValuesHelper> getPersonsAll() {

        int page = 1, size = 5;
        Sort sort = new Sort(Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);

        PaginationMultiTypeValuesHelper multiValue = new PaginationMultiTypeValuesHelper();
        Map<String, PaginationMultiTypeValuesHelper> results = new HashMap<>();

        Integer count = personsRepository.findAll(pageable).getSize();
        Integer page_number = personsRepository.findAll(pageable).getNumber();

        Object content = personsRepository.findAll(pageable).getContent();
        Long total = personsRepository.count();
        multiValue.setCount(count);
        multiValue.setPage(page_number);
        multiValue.setResults(content);
        multiValue.setTotal(total);

        results.put("data", multiValue);
        return results;
    }

}