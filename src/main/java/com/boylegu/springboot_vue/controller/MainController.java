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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;

import com.boylegu.springboot_vue.controller.pagination.PaginationMultiTypeValuesHelper;
import com.boylegu.springboot_vue.dao.PersonsRepository;
import com.boylegu.springboot_vue.controller.pagination.PaginationFormatting;

import java.util.*;


@RestController
@RequestMapping("/api/persons")
public class MainController {

    @Autowired
    private PersonsRepository personsRepository;

    @Value(("${com.boylegu.paginatio.max-per-page}"))
    Integer maxPerPage;

    @RequestMapping(value = "/sex", method = RequestMethod.GET)
    public ResponseEntity<?> getSexAll() {

        /*
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
    public Map<String, PaginationMultiTypeValuesHelper> getPersonsAll(
            @RequestParam(value = "page", required = false) Integer pages,
            @RequestParam("sex") String sex,
            @RequestParam("email") String email
    ) {

        /*
         *   @api {GET} /api/persons   Get all or a part of person info
         *   @apiName GetAllInfoList
         *   @apiGroup Info Manage
         *   @apiVersion 1.0.0
         *
         *   @apiExample {httpie} Example usage: (support combinatorial search)
         *
         *       All person：
         *       http /api/persons
         *
         *       You can according to 'sex | email' or 'sex & email'
         *       http /api/persons?sex=xxx&email=xx
         *       http /api/persons?sex=xxx
         *       http /api/persons?email=xx
         *
         *       @apiParam {String} sex
         *       @apiParam {String} email
         *
         *   @apiSuccess {String} create_datetime
         *   @apiSuccess {String} email
         *   @apiSuccess {String} id
         *   @apiSuccess {String} phone
         *   @apiSuccess {String} sex
         *   @apiSuccess {String} username
         *   @apiSuccess {String} zone
         */

        if (pages == null) {

            pages = 1;

        }

        Sort sort = new Sort(Direction.ASC, "id");

        Pageable pageable = new PageRequest(pages - 1, maxPerPage, sort);

        PaginationFormatting paginInstance = new PaginationFormatting();

        return paginInstance.filterQuery(sex, email, pageable);
    }

}