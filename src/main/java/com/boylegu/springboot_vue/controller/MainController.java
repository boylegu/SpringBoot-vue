package com.boylegu.springboot_vue.controller;

import com.boylegu.springboot_vue.entities.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Page;
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

    @Value(("${com.boylegu.paginatio.max-per-page}"))
    Integer maxPerPage;

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

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    //public Map<String, PaginationMultiTypeValuesHelper> getPersonsAll
    public Map<String, PaginationMultiTypeValuesHelper> getPersonsAll(
            @RequestParam(value = "page", required = false) Integer pages,
            @RequestParam("sex") String sex,
            @RequestParam("email") String email
    ) {

        if (pages == null) {
            pages = 1;
        }
        Sort sort = new Sort(Direction.ASC, "id");

        Pageable pageable = new PageRequest(pages - 1, maxPerPage, sort);

        PaginationMultiTypeValuesHelper multiValue = new PaginationMultiTypeValuesHelper();
        Map<String, PaginationMultiTypeValuesHelper> results = new HashMap<>();

        Integer count, page_number;
        Object content;
        Long total;
        if (sex.length() == 0 && email.length() == 0) {
            count = personsRepository.findAll(pageable).getSize();
            page_number = personsRepository.findAll(pageable).getNumber();
            content = personsRepository.findAll(pageable).getContent();
            total = personsRepository.findAll(pageable).getTotalElements();

        } else if (sex.length() > 0 && email.length() > 0) {
            count = personsRepository.findBySexAndEmailContains(sex, email, pageable).getSize();
            page_number = personsRepository.findBySexAndEmailContains(sex, email, pageable).getNumber();
            content = personsRepository.findBySexAndEmailContains(sex, email, pageable).getContent();
            total = personsRepository.findBySexAndEmailContains(sex, email, pageable).getTotalElements();

        } else {
            count = personsRepository.findBySex(sex, pageable).getSize();
            page_number = personsRepository.findBySex(sex, pageable).getNumber();
            content = personsRepository.findBySex(sex, pageable).getContent();
            total = personsRepository.findBySex(sex, pageable).getTotalElements();

        }

        multiValue.setCount(count);
        multiValue.setPage(page_number + 1);
        multiValue.setResults(content);
        multiValue.setTotal(total);
        results.put("data", multiValue);

        return results;
    }

}